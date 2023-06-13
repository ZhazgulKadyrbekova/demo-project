package crud.mvc.project.model.request;

import crud.mvc.project.entity.enums.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class OperationUpdateRequest {
    public BigDecimal totalAmount;
    public OperationStatus status;

}
