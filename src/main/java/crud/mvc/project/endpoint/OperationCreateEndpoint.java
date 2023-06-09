package crud.mvc.project.endpoint;

import crud.mvc.project.model.dto.OperationCreateDto;
import crud.mvc.project.model.payload.OperationCreatePayload;

public interface OperationCreateEndpoint {
    OperationCreateDto create(String cashDeskName, OperationCreatePayload createPayload);
}
