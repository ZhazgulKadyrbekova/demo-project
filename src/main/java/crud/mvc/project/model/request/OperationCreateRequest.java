package crud.mvc.project.model.request;

import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.entity.Currency;

import java.math.BigDecimal;

public class OperationCreateRequest {
    public BigDecimal amount;
    public Currency currency;
    public CashDesk fromCashDesk;
    public CashDesk toCashDesk;
    public String senderName;
    public String receiverName;
    public String senderPhoneNumber;
    public String receiverPhoneNumber;
    public String description;

    public OperationCreateRequest(BigDecimal amount, Currency currency, CashDesk fromCashDesk, CashDesk toCashDesk,
                                  String senderName, String receiverName, String senderPhoneNumber,
                                  String receiverPhoneNumber, String description) {
        this.amount = amount;
        this.currency = currency;
        this.fromCashDesk = fromCashDesk;
        this.toCashDesk = toCashDesk;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.senderPhoneNumber = senderPhoneNumber;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.description = description;
    }

}
