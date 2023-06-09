package crud.mvc.project.model.dto;

import crud.mvc.project.entity.OperationStatus;

public class OperationUpdateDto {
    public long id;
    public OperationStatus status;

    public OperationUpdateDto(long id, OperationStatus status) {
        this.id = id;
        this.status = status;
    }
}
