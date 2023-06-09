package crud.mvc.project.exception;

public class OperationFilterException extends RuntimeException {
    String fromFieldName;
    String toFieldName;
    Object fromValue;
    Object toValue;

    public OperationFilterException(String fromFieldName, String toFieldName,
                                    Object fromValue, Object toValue) {
        super("Make sure you entered right information: " + fromFieldName + ": "
                + fromValue + " and " + toFieldName + ": " + toValue);
        this.fromFieldName = fromFieldName;
        this.toFieldName = toFieldName;
        this.fromValue = fromValue;
        this.toValue = toValue;
    }

}
