package crud.mvc.project.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CashDeskAuthLoginPayload {
    public String username;
    public String password;

}
