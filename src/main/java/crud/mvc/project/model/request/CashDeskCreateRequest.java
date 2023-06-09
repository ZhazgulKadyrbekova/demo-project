package crud.mvc.project.model.request;

import java.math.BigDecimal;

public class CashDeskCreateRequest {
    public BigDecimal balance;
    public String name;

    public CashDeskCreateRequest(BigDecimal balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}
