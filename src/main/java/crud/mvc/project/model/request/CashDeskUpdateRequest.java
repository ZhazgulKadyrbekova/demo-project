package crud.mvc.project.model.request;

import java.math.BigDecimal;

public class CashDeskUpdateRequest {
    public BigDecimal balance;

    public CashDeskUpdateRequest(BigDecimal balance) {
        this.balance = balance;
    }
}
