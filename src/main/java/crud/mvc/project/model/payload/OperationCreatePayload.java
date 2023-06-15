package crud.mvc.project.model.payload;

import crud.mvc.project.entity.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperationCreatePayload {
    @NotNull
    @Min(value = 1, message = "Minimum amount for successful transaction execution is 1.")
    BigDecimal amount;

    @NotNull
    Currency currency;

    @Min(value = 1, message = "Enter valid info for cash desk id")
    long toCashDesk;

    @NotNull
    @NotBlank(message = "Sender's name can not be empty")
    String senderName;

    @NotNull
    @NotBlank(message = "Receiver's name can not be empty")
    String receiverName;

    @Min(value = 996000000000L)
    Long senderPhoneNumber;

    @Min(value = 996000000000L)
    Long receiverPhoneNumber;

    String description;

    @Override
    public String toString() {
        return "OperationCreatePayload{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", toCashDesk=" + toCashDesk +
                ", senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", senderPhoneNumber=" + senderPhoneNumber +
                ", receiverPhoneNumber=" + receiverPhoneNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
