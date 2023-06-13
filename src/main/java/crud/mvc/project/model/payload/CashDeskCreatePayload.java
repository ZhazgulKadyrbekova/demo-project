package crud.mvc.project.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CashDeskCreatePayload {
    @NotNull
    @NotBlank
    public String name;
    @NotNull
    @NotBlank
    public String username;
    @NotNull
    @Min(value = 0)
    public BigDecimal balance;
    @NotNull
    @NotBlank
    public String password;

}
