package crud.mvc.project.model.dto;

import crud.mvc.project.entity.enums.Currency;
import crud.mvc.project.entity.enums.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class OperationDto {
    BigDecimal amount;
    Currency currency;
    CashDeskDto fromCashDesk;
    CashDeskDto toCashDesk;
    String senderName;
    String receiverName;
    String senderPhoneNumber;
    String receiverPhoneNumber;
    OperationStatus status;
    String description;
    String createdDate;
}
