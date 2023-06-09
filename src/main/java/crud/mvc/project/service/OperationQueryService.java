package crud.mvc.project.service;

import crud.mvc.project.entity.Operation;
import crud.mvc.project.model.payload.OperationFilterPayload;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface OperationQueryService {
    Page<Operation> getAll(PageRequest pageRequest);
    Page<Operation> getAllBySearch(String searchField, PageRequest pageRequest);
    Page<Operation> getAllByFilter(OperationFilterPayload operationFilterPayload, PageRequest pageRequest);
    Operation getByCodeAndToCashDeskId(String code, long cashDeskId);
}
