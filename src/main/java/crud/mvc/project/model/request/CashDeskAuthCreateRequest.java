package crud.mvc.project.model.request;

public class CashDeskAuthCreateRequest {
    public String username;
    public String password;

    public CashDeskAuthCreateRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
