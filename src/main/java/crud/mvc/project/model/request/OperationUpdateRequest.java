package crud.mvc.project.model.request;

import crud.mvc.project.entity.OperationStatus;

import java.math.BigDecimal;

public class OperationUpdateRequest {
    public BigDecimal totalAmount;
    public OperationStatus status;

    public OperationUpdateRequest(BigDecimal totalAmount, OperationStatus status) {
        this.totalAmount = totalAmount;
        this.status = status;
    }
}
