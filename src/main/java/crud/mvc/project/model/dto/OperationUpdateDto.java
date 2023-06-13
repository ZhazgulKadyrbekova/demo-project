package crud.mvc.project.model.dto;

import crud.mvc.project.entity.enums.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OperationUpdateDto {
    public long id;
    public OperationStatus status;

}
