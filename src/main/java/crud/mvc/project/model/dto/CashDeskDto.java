package crud.mvc.project.model.dto;

import java.math.BigDecimal;

public class CashDeskDto {
    public long id;
    public BigDecimal balance;
    public String name;

    public CashDeskDto(long id, BigDecimal balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
