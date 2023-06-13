package crud.mvc.project.entity.enums;

import java.math.BigDecimal;

public enum Currency {
    SOM(1.0),
    DOLLAR(87.0),
    EURO(90.0),
    RUBLE(1.2),
    TENGE(0.2);

    public final BigDecimal exchangeRate;

    Currency(double exchangeRate) {
        this.exchangeRate = new BigDecimal(exchangeRate);
    }
}
