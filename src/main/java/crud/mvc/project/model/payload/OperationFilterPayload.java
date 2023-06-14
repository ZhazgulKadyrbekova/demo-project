package crud.mvc.project.model.payload;

import crud.mvc.project.entity.enums.Currency;
import crud.mvc.project.entity.enums.OperationStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OperationFilterPayload {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public int page = 0;

    public List<Long> fromCashDeskIds;
    public List<Long> toCashDeskIds;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime dateFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime dateTo;

    public OperationStatus status;
    public List<Currency> currencies;
    public BigDecimal amountFrom;
    public BigDecimal amountTo;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
