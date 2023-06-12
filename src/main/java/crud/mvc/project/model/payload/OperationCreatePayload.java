package crud.mvc.project.model.payload;

import crud.mvc.project.entity.Currency;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OperationCreatePayload {
    @NotNull
    @Min(value = 1, message = "Minimum amount for successful transaction execution is 1.")
    public BigDecimal amount;
    @NotNull
    public Currency currency;
    @Min(value = 1, message = "Enter valid info for cash desk id")
    public long toCashDesk;
    @NotNull
    @NotBlank(message = "Sender's name can not be empty")
    public String senderName;
    @NotNull
    @NotBlank(message = "Receiver's name can not be empty")
    public String receiverName;
    @Min(value = 996000000000L)
    public Long senderPhoneNumber;
    @Min(value = 996000000000L)
    public Long receiverPhoneNumber;
    public String description;

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

    public long getToCashDesk() {
        return toCashDesk;
    }

    public void setToCashDesk(long toCashDesk) {
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

    public Long getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(Long senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public Long getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(Long receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return amount + ", " + currency + ", " + toCashDesk + ", " + senderName + ","
                + receiverName + ", " + senderPhoneNumber + ", " + receiverPhoneNumber + ", " + description;
    }
}
