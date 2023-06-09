package crud.mvc.project.service;

import com.querydsl.core.BooleanBuilder;
import crud.mvc.project.entity.Operation;
import crud.mvc.project.model.request.OperationCreateRequest;
import crud.mvc.project.model.request.OperationUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface OperationEntityService {
    Operation create(OperationCreateRequest model);
    Operation update(Operation operation, OperationUpdateRequest updateRequest);
    Operation findByQuery(BooleanBuilder booleanBuilder);
    Page<Operation> findAll(PageRequest pageRequest, BooleanBuilder booleanBuilder);
}
