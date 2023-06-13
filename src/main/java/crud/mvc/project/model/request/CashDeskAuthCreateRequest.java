package crud.mvc.project.model.request;

import crud.mvc.project.entity.CashDeskRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CashDeskAuthCreateRequest {
    public String username;
    public String password;
    public CashDeskRole role;
}
