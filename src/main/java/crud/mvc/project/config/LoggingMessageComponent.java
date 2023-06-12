package crud.mvc.project.config;

import crud.mvc.project.util.LoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Component
public class LoggingMessageComponent {

    public void logErrorMessage(HttpStatus statusCode, Exception exception) {
        logErrorMessageWithoutStackTrace(statusCode, exception);
        LoggerUtil.getLogger().error(exception.getMessage(), exception.getStackTrace());
    }

    public void logErrorMessageWithoutStackTrace(HttpStatus statusCode, Exception exception) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        LocalDateTime executionTime = LocalDateTime.now();


        LoggerUtil.getLogger().error(
                "URL: " + request.getRequestURL() + ", method: " + request.getMethod() + " , queryString: " +
                        request.getQueryString() + ", status code: " + statusCode + ", execution time: " +
                        executionTime + ", message: " + exception.getMessage()
        );
    }
}
