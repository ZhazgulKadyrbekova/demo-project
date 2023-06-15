package crud.mvc.project.endpoint.impl;

import crud.mvc.project.endpoint.OperationCreateEndpoint;
import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.entity.Operation;
import crud.mvc.project.entity.enums.OperationStatus;
import crud.mvc.project.exception.CreateOperationException;
import crud.mvc.project.exception.InvalidMoneyAmountException;
import crud.mvc.project.mapper.OperationMapperService;
import crud.mvc.project.model.dto.OperationCreateDto;
import crud.mvc.project.model.payload.OperationCreatePayload;
import crud.mvc.project.model.request.OperationCreateRequest;
import crud.mvc.project.service.CashDeskQueryService;
import crud.mvc.project.service.OperationEntityService;
import crud.mvc.project.util.CodeUtilHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OperationCreateEndpointImpl implements OperationCreateEndpoint {
    private final CashDeskQueryService cashDeskQueryService;
    private final OperationEntityService operationEntityService;
    private final OperationMapperService operationMapperService;

    public OperationCreateEndpointImpl(CashDeskQueryService cashDeskQueryService,
                                       OperationEntityService operationEntityService,
                                       OperationMapperService operationMapperService) {
        this.cashDeskQueryService = cashDeskQueryService;
        this.operationEntityService = operationEntityService;
        this.operationMapperService = operationMapperService;
    }

    @Override
    @Transactional
    public OperationCreateDto create(String cashDeskName, OperationCreatePayload createPayload) {
        checkBalanceInformation(createPayload.getAmount());
        checkNameInformation(createPayload.getSenderName(), createPayload.getReceiverName());

        String senderPhoneNumber = null;
        if (createPayload.getSenderPhoneNumber() != null) {
            senderPhoneNumber = String.valueOf(createPayload.getSenderPhoneNumber());
        }

        String receiverPhoneNumber = null;
        if (createPayload.getReceiverPhoneNumber() != null) {
            receiverPhoneNumber = String.valueOf(createPayload.getReceiverPhoneNumber());
        }
        checkPhoneNumberInformation(senderPhoneNumber, receiverPhoneNumber);

        CashDesk fromCashDesk = cashDeskQueryService.getByUsername(cashDeskName);
        CashDesk toCashDesk = cashDeskQueryService.getById(createPayload.getToCashDesk());

        checkCashDeskInformation(fromCashDesk.getId(), toCashDesk.getId());

        OperationCreateRequest operationCreateRequest = new OperationCreateRequest(
                createPayload.getAmount(),
                createPayload.getCurrency(),
                fromCashDesk,
                toCashDesk,
                createPayload.getSenderName(),
                createPayload.getReceiverName(),
                senderPhoneNumber,
                receiverPhoneNumber,
                createPayload.getDescription(),
                OperationStatus.CREATED,
                CodeUtilHelper.generateCode()
        );
        Operation operation = operationEntityService.create(operationCreateRequest);
        return operationMapperService.mapToCreateDto(operation);
    }

    private void checkBalanceInformation(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ONE) == -1) {
            throw new InvalidMoneyAmountException(amount);
        }
    }

    private void checkCashDeskInformation(long toCashDesk, long fromCashDesk) {
        if (toCashDesk == fromCashDesk) {
            throw new CreateOperationException("toCashDesk", "fromCashDesk", toCashDesk, fromCashDesk);
        }
    }

    private void checkNameInformation(String senderName, String receiverName) {
        if (senderName.equals(receiverName)) {
            throw new CreateOperationException("senderName", "receiverName", senderName, receiverName);
        }
    }

    private void checkPhoneNumberInformation(String senderPhoneNumber, String receiverPhoneNumber) {
        if (senderPhoneNumber != null && receiverPhoneNumber != null &&
                senderPhoneNumber.equals(receiverPhoneNumber)) {
            throw new CreateOperationException("senderPhoneNumber", "receiverPhoneNumber", senderPhoneNumber, receiverPhoneNumber);
        }
    }
}
