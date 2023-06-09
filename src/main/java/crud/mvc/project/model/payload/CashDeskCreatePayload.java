package crud.mvc.project.model.payload;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CashDeskCreatePayload {
    @NotNull
    @NotBlank
    public String name;
    @NotNull
    @Min(value = 0)
    public BigDecimal balance;
    @NotNull
    @NotBlank
    public String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CashDeskCreatePayload(String name, BigDecimal balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
    }
}
