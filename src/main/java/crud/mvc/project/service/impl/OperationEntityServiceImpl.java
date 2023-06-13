package crud.mvc.project.service.impl;

import com.querydsl.core.BooleanBuilder;
import crud.mvc.project.entity.Operation;
import crud.mvc.project.model.request.OperationCreateRequest;
import crud.mvc.project.model.request.OperationUpdateRequest;
import crud.mvc.project.repository.OperationRepository;
import crud.mvc.project.service.OperationEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OperationEntityServiceImpl implements OperationEntityService {

    private final OperationRepository repository;

    public OperationEntityServiceImpl(OperationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Operation create(OperationCreateRequest model) {
        Operation operation = Operation.builder()
                .amount(model.amount)
                .currency(model.currency)
                .fromCashDesk(model.fromCashDesk)
                .toCashDesk(model.toCashDesk)
                .senderName(model.senderName)
                .receiverName(model.receiverName)
                .senderPhoneNumber(model.senderPhoneNumber)
                .receiverPhoneNumber(model.receiverPhoneNumber)
                .description(model.description)
                .build();

        return repository.save(operation);
    }

    @Override
    public Operation update(Operation operation, OperationUpdateRequest updateRequest) {
        operation.setStatus(updateRequest.status);
        operation.setSomAmount(updateRequest.totalAmount);

        return repository.save(operation);
    }

    @Override
    public Operation findByQuery(BooleanBuilder booleanBuilder) {
        return repository.findOne(booleanBuilder).orElse(null);
    }

    @Override
    public Page<Operation> findAll(PageRequest pageRequest, BooleanBuilder booleanBuilder) {
        return repository.findAll(booleanBuilder, pageRequest);
    }

}
