package crud.mvc.project.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    public static <T> Logger getLogger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    public static <T> Logger getLogger() {
        return getLogger(LoggerUtil.class);
    }
}

