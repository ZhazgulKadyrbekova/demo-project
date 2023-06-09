package crud.mvc.project.service.impl;

import com.querydsl.core.BooleanBuilder;
import crud.mvc.project.entity.Operation;
import crud.mvc.project.entity.QOperation;
import crud.mvc.project.exception.NotFoundException;
import crud.mvc.project.model.payload.OperationFilterPayload;
import crud.mvc.project.service.OperationEntityService;
import crud.mvc.project.service.OperationQueryService;
import crud.mvc.project.util.ListUtilHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OperationQueryServiceImpl implements OperationQueryService {

    private final OperationEntityService entityService;

    public OperationQueryServiceImpl(OperationEntityService entityService) {
        this.entityService = entityService;
    }

    @Override
    public Page<Operation> getAll(PageRequest pageRequest) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        return entityService.findAll(pageRequest, booleanBuilder);
    }

    @Override
    public Page<Operation> getAllBySearch(String searchField, PageRequest pageRequest) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        booleanBuilder.or(QOperation.operation.senderName.containsIgnoreCase(searchField));
        booleanBuilder.or(QOperation.operation.receiverName.containsIgnoreCase(searchField));
        booleanBuilder.or(QOperation.operation.senderPhoneNumber.containsIgnoreCase(searchField));
        booleanBuilder.or(QOperation.operation.receiverPhoneNumber.containsIgnoreCase(searchField));
        return entityService.findAll(pageRequest, booleanBuilder);
    }


    @Override
    public Page<Operation> getAllByFilter(OperationFilterPayload operationFilterPayload, PageRequest pageRequest) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (ListUtilHelper.isNotNullOrEmpty(operationFilterPayload.fromCashDeskIds)) {
            booleanBuilder.and(QOperation.operation.fromCashDesk.id.in(operationFilterPayload.fromCashDeskIds));
        }
        if (ListUtilHelper.isNotNullOrEmpty(operationFilterPayload.toCashDeskIds)) {
            booleanBuilder.and(QOperation.operation.toCashDesk.id.in(operationFilterPayload.toCashDeskIds));
        }
        if (operationFilterPayload.dateFrom != null) {
            booleanBuilder.and(QOperation.operation.createdDate.after(operationFilterPayload.dateFrom));
        }
        if (operationFilterPayload.dateTo != null) {
            booleanBuilder.and(QOperation.operation.createdDate.before(operationFilterPayload.dateTo));
        }
        if (operationFilterPayload.status != null) {
            booleanBuilder.and(QOperation.operation.status.eq(operationFilterPayload.status));
        }
        if (ListUtilHelper.isNotNullOrEmpty(operationFilterPayload.currencies)) {
            booleanBuilder.and(QOperation.operation.currency.in(operationFilterPayload.currencies));
        }
        if (operationFilterPayload.amountFrom != null) {
            booleanBuilder.and(QOperation.operation.amount.goe(operationFilterPayload.amountFrom));
        }
        if (operationFilterPayload.amountTo != null) {
            booleanBuilder.and(QOperation.operation.amount.loe(operationFilterPayload.amountTo));
        }

        return entityService.findAll(pageRequest, booleanBuilder);
    }

    @Override
    public Operation getByCodeAndToCashDeskId(String code, long cashDeskId) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(QOperation.operation.code.eq(code));
        builder.and(QOperation.operation.toCashDesk.id.eq(cashDeskId));

        Operation operation = entityService.findByQuery(builder);
        if (operation != null) {
            return operation;
        } else {
            throw new NotFoundException("Operation", "code", code);
        }
    }
}
