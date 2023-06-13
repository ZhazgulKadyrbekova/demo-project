package crud.mvc.project.model.dto;

import crud.mvc.project.entity.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
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

}
