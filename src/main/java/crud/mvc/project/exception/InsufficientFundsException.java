package crud.mvc.project.exception;

//недостаточно средств
public class InsufficientFundsException extends RuntimeException {
    String cashDeskName;

    public InsufficientFundsException(String cashDeskName) {
        super("Insufficient funds on cash desk " + cashDeskName + ".Try again later!");
        this.cashDeskName = cashDeskName;
    }
}
