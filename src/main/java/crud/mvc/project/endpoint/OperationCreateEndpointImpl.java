package crud.mvc.project.endpoint;

import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.entity.Operation;
import crud.mvc.project.exception.CreateOperationException;
import crud.mvc.project.exception.InvalidMoneyAmountException;
import crud.mvc.project.exception.InvalidPhoneNumberException;
import crud.mvc.project.mapper.OperationMapperService;
import crud.mvc.project.model.dto.OperationCreateDto;
import crud.mvc.project.model.payload.OperationCreatePayload;
import crud.mvc.project.model.request.OperationCreateRequest;
import crud.mvc.project.service.CashDeskQueryService;
import crud.mvc.project.service.OperationEntityService;
import org.springframework.stereotype.Service;

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
    public OperationCreateDto create(String cashDeskName, OperationCreatePayload createPayload) {
        checkBalanceInformation(createPayload.amount);
        checkNameInformation(createPayload.senderName, createPayload.receiverName);
        checkPhoneNumberInformation(createPayload.senderPhoneNumber, createPayload.receiverPhoneNumber);
        checkPhoneNumberInformation(createPayload.senderPhoneNumber);
        checkPhoneNumberInformation(createPayload.receiverPhoneNumber);

        CashDesk fromCashDesk = cashDeskQueryService.getByName(cashDeskName);
        CashDesk toCashDesk = cashDeskQueryService.getById(createPayload.toCashDesk);

        checkCashDeskInformation(fromCashDesk.getId(), toCashDesk.getId());

        OperationCreateRequest operationCreateRequest = new OperationCreateRequest(
                createPayload.amount,
                createPayload.currency,
                fromCashDesk,
                toCashDesk,
                createPayload.senderName,
                createPayload.receiverName,
                createPayload.senderPhoneNumber,
                createPayload.receiverPhoneNumber,
                createPayload.description
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
        if (senderPhoneNumber != null && receiverPhoneNumber != null && senderPhoneNumber.equals(receiverPhoneNumber)) {
            throw new CreateOperationException("senderPhoneNumber", "receiverPhoneNumber", senderPhoneNumber, receiverPhoneNumber);
        }
    }

    private void checkPhoneNumberInformation(String phoneNumber) {
        if (phoneNumber == null) {
            return;
        }

        if (!phoneNumber.startsWith("+")) {
            throw new InvalidPhoneNumberException(phoneNumber);
        }
    }
}
