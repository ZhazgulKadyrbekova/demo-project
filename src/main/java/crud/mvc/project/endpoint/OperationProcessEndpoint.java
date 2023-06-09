package crud.mvc.project.endpoint;

import crud.mvc.project.model.dto.OperationUpdateDto;
import crud.mvc.project.model.payload.OperationProcessPayload;

public interface OperationProcessEndpoint {
    OperationUpdateDto process(String toCashDeskName, OperationProcessPayload processPayload);
}
