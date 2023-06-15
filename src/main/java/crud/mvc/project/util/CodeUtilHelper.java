package crud.mvc.project.util;

import java.util.UUID;

public class CodeUtilHelper {
    public static String generateCode() {
        return UUID.randomUUID().toString().substring(0,8);
    }
}
