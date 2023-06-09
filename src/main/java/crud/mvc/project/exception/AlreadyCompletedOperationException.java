package crud.mvc.project.exception;

public class AlreadyCompletedOperationException extends RuntimeException {

    public AlreadyCompletedOperationException() {
        super("Operation is already completed !");
    }
}
