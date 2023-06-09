package crud.mvc.project.exception;

public class NotFoundException extends RuntimeException {
    String className;
    String field;
    Object value;

    public NotFoundException(String className, String field, Object value) {
        super(className + " with " + field + " = " + value + " is not found !");
        this.className = className;
        this.field = field;
        this.value = value;
    }


}
