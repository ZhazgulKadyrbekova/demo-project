package crud.mvc.project.model.request;

import crud.mvc.project.entity.CashDeskAuth;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CashDeskCreateRequest {
    public BigDecimal balance;
    public String name;
    public CashDeskAuth auth;
}
