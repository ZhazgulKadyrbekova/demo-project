package crud.mvc.project.exception;

import java.math.BigDecimal;

public class InvalidMoneyAmountException extends RuntimeException {
    BigDecimal amount;

    public InvalidMoneyAmountException(BigDecimal amount) {
        super("Make sure you entered right amount of money to send: " + amount);
        this.amount = amount;
    }

}
