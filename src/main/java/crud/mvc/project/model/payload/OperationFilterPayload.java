package crud.mvc.project.model.payload;

import crud.mvc.project.entity.Currency;
import crud.mvc.project.entity.OperationStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OperationFilterPayload {
    public int page = 0;
    public int size = 5;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Long> getFromCashDeskIds() {
        return fromCashDeskIds;
    }

    public void setFromCashDeskIds(List<Long> fromCashDeskIds) {
        this.fromCashDeskIds = fromCashDeskIds;
    }

    public List<Long> getToCashDeskIds() {
        return toCashDeskIds;
    }

    public void setToCashDeskIds(List<Long> toCashDeskIds) {
        this.toCashDeskIds = toCashDeskIds;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public BigDecimal getAmountFrom() {
        return amountFrom;
    }

    public void setAmountFrom(BigDecimal amountFrom) {
        this.amountFrom = amountFrom;
    }

    public BigDecimal getAmountTo() {
        return amountTo;
    }

    public void setAmountTo(BigDecimal amountTo) {
        this.amountTo = amountTo;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
