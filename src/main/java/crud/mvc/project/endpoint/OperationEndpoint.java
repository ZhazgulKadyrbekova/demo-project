package crud.mvc.project.endpoint;

import crud.mvc.project.model.dto.OperationDto;
import crud.mvc.project.model.payload.OperationFilterPayload;
import crud.mvc.project.model.payload.OperationGetAllPayload;
import crud.mvc.project.model.payload.OperationSearchPayload;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OperationEndpoint {
    Page<OperationDto> getAll(OperationGetAllPayload operationGetAllPayload);
    Page<OperationDto> search(OperationSearchPayload operationSearchPayload);
    Page<OperationDto> filter(OperationFilterPayload operationFilterPayload);

//    List<Operation> getAll(AuthPrincipalDetailsImpl authPrincipalDetails, OperationEndpointGetAllPayload operationEndpointGetAllPayload);
}
