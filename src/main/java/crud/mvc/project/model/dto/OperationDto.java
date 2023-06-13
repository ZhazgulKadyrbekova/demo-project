package crud.mvc.project.model.dto;

import crud.mvc.project.entity.Currency;
import crud.mvc.project.entity.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
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

}
