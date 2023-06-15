package crud.mvc.project.model.request;

import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.entity.enums.Currency;
import crud.mvc.project.entity.enums.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
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
    public OperationStatus status;
    public String code;
}
