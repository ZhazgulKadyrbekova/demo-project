package crud.mvc.project.exception;

public class InvalidInformationException extends RuntimeException {
    String senderName;
    String receiverName;

    public InvalidInformationException(String senderName, String receiverName) {
        super("Make sure you entered right information: senderName:" +
                senderName + "receiverName:" + receiverName + ".Try again!");
        this.senderName = senderName;
        this.receiverName = receiverName;
    }
}
