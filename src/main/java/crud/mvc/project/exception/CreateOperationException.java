package crud.mvc.project.exception;

public class CreateOperationException extends RuntimeException {
    String senderField;
    String receiverField;
    Object senderValue;
    Object receiverValue;

    public CreateOperationException(String senderField, String receiverField,
                                    Object senderValue, Object receiverValue) {
        super("Make sure you entered right information to create new operation: " + senderField + ": "
                + senderValue + "; " + receiverField + ": " + receiverValue + ". Try again!");
        this.senderField = senderField;
        this.receiverField = receiverField;
        this.senderValue = senderValue;
        this.receiverValue = receiverValue;
    }
}
