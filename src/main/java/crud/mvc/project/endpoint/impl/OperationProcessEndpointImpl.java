package crud.mvc.project.endpoint.impl;

import crud.mvc.project.endpoint.OperationProcessEndpoint;
import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.entity.enums.Currency;
import crud.mvc.project.entity.Operation;
import crud.mvc.project.entity.enums.OperationStatus;
import crud.mvc.project.exception.AlreadyCompletedOperationException;
import crud.mvc.project.exception.InsufficientFundsException;
import crud.mvc.project.exception.InvalidInformationException;
import crud.mvc.project.mapper.OperationMapperService;
import crud.mvc.project.model.dto.OperationUpdateDto;
import crud.mvc.project.model.request.CashDeskUpdateRequest;
import crud.mvc.project.model.payload.OperationProcessPayload;
import crud.mvc.project.model.request.OperationUpdateRequest;
import crud.mvc.project.service.CashDeskEntityService;
import crud.mvc.project.service.CashDeskQueryService;
import crud.mvc.project.service.OperationEntityService;
import crud.mvc.project.service.OperationQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OperationProcessEndpointImpl implements OperationProcessEndpoint {
    private final CashDeskEntityService cashDeskEntityService;
    private final CashDeskQueryService cashDeskQueryService;
    private final OperationEntityService operationEntityService;
    private final OperationQueryService operationQueryService;
    private final OperationMapperService operationMapperService;

    public OperationProcessEndpointImpl(CashDeskEntityService cashDeskEntityService, CashDeskQueryService cashDeskQueryService,
                                        OperationEntityService operationEntityService, OperationQueryService operationQueryService,
                                        OperationMapperService operationMapperService) {
        this.cashDeskEntityService = cashDeskEntityService;
        this.cashDeskQueryService = cashDeskQueryService;
        this.operationEntityService = operationEntityService;
        this.operationQueryService = operationQueryService;
        this.operationMapperService = operationMapperService;
    }

    @Override
    @Transactional
    public OperationUpdateDto process(String toCashDeskName, OperationProcessPayload processPayload) {
        CashDesk cashDesk = cashDeskQueryService.getByUsername(toCashDeskName);
        Operation operation = operationQueryService.getByCodeAndToCashDeskId(processPayload.code, cashDesk.getId());

        if (operation.getStatus() == OperationStatus.COMPLETED) {
            throw new AlreadyCompletedOperationException();
        }

        BigDecimal totalSomAmount = calculateTotalAmount(operation.getAmount(), operation.getCurrency());
        CashDesk fromCashDesk = operation.getFromCashDesk();

        checkNameInformation(operation, processPayload);
        checkBalanceInformation(fromCashDesk, totalSomAmount);

        //first cash desk
        CashDeskUpdateRequest fromUpdateModel = new CashDeskUpdateRequest(
                fromCashDesk.getBalance().subtract(totalSomAmount)
        );

        cashDeskEntityService.update(fromCashDesk, fromUpdateModel);

        //second cash desk
        CashDesk toCashDesk = operation.getToCashDesk();
        CashDeskUpdateRequest toUpdateModel = new CashDeskUpdateRequest(
                toCashDesk.getBalance().add(totalSomAmount)
        );
        cashDeskEntityService.update(toCashDesk, toUpdateModel);

        //status of operation
        OperationUpdateRequest updateRequest = new OperationUpdateRequest(
                totalSomAmount,
                OperationStatus.COMPLETED
        );
        operationEntityService.update(operation, updateRequest);
        return operationMapperService.mapToUpdateDto(operation);
    }

    private void checkNameInformation(Operation operation, OperationProcessPayload processPayload) {
        if (!operation.getSenderName().equals(processPayload.senderName)
                || !operation.getReceiverName().equals(processPayload.receiverName)) {
            throw new InvalidInformationException(processPayload.senderName, processPayload.receiverName);
        }
    }

    private void checkBalanceInformation(CashDesk cashDesk, BigDecimal totalSomAmount) {
        BigDecimal cashDeskBalance = cashDesk.getBalance();

        if (cashDeskBalance.compareTo(totalSomAmount) == -1) {
            throw new InsufficientFundsException(cashDesk.getName());
        }
    }

    private BigDecimal calculateTotalAmount(BigDecimal amount, Currency currency) {
        return amount.multiply(currency.exchangeRate);
    }
}
