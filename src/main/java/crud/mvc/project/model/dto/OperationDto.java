package crud.mvc.project.model.dto;

import crud.mvc.project.entity.Currency;
import crud.mvc.project.entity.OperationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OperationDto {
    public BigDecimal amount;
    public Currency currency;
    public CashDeskDto fromCashDesk;
    public CashDeskDto toCashDesk;
    public String senderName;
    public String receiverName;
    public String senderPhoneNumber;
    public String receiverPhoneNumber;
    public OperationStatus status;
    public String description;
    public LocalDateTime createdDate;


    public OperationDto(BigDecimal amount, Currency currency, CashDeskDto fromCashDesk, CashDeskDto toCashDesk,
                        String senderName, String receiverName, String senderPhoneNumber, String receiverPhoneNumber,
                        OperationStatus status, String description, LocalDateTime createdDate) {
        this.amount = amount;
        this.currency = currency;
        this.fromCashDesk = fromCashDesk;
        this.toCashDesk = toCashDesk;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.senderPhoneNumber = senderPhoneNumber;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.status = status;
        this.description = description;
        this.createdDate = createdDate;
    }
}
