package crud.mvc.project.model.dto;

import crud.mvc.project.entity.Currency;

import java.math.BigDecimal;

public class OperationCreateDto {
    public BigDecimal amount;
    public Currency currency;
    public CashDeskDto fromCashDesk;
    public CashDeskDto toCashDesk;
    public String toCashDeskName;
    public String senderName;
    public String receiverName;
    public String senderPhoneNumber;
    public String receiverPhoneNumber;
    public String description;
    public String code;


    public OperationCreateDto(BigDecimal amount, Currency currency, CashDeskDto fromCashDesk, CashDeskDto toCashDesk,
                              String toCashDeskName, String senderName, String receiverName, String senderPhoneNumber,
                              String receiverPhoneNumber, String description, String code) {
        this.amount = amount;
        this.currency = currency;
        this.fromCashDesk = fromCashDesk;
        this.toCashDesk = toCashDesk;
        this.toCashDeskName = toCashDeskName;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.senderPhoneNumber = senderPhoneNumber;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.description = description;
        this.code = code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CashDeskDto getFromCashDesk() {
        return fromCashDesk;
    }

    public void setFromCashDesk(CashDeskDto fromCashDesk) {
        this.fromCashDesk = fromCashDesk;
    }

    public CashDeskDto getToCashDesk() {
        return toCashDesk;
    }

    public void setToCashDesk(CashDeskDto toCashDesk) {
        this.toCashDesk = toCashDesk;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToCashDeskName() {
        return toCashDeskName;
    }

    public void setToCashDeskName(String toCashDeskName) {
        this.toCashDeskName = toCashDeskName;
    }
}
