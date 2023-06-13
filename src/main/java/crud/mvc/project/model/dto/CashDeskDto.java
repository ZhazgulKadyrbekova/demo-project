package crud.mvc.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CashDeskDto {
    public long id;
    public String name;
    public BigDecimal balance;
}
