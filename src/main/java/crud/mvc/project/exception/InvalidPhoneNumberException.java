package crud.mvc.project.exception;

public class InvalidPhoneNumberException extends RuntimeException {
    String phoneNumber;

    public InvalidPhoneNumberException(String phoneNumber) {
        super("Invalid phone number: " + phoneNumber + ". It must include country code and start with +");
        this.phoneNumber = phoneNumber;
    }

}
