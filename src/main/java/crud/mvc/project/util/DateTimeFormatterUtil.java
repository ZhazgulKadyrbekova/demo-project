package crud.mvc.project.util;

import java.time.format.DateTimeFormatter;

public class DateTimeFormatterUtil {
    public static DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }
}
