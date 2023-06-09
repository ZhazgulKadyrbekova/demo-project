package crud.mvc.project.controller;

import crud.mvc.project.config.LoggingMessageComponent;
import crud.mvc.project.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class AdviceController {

    private final LoggingMessageComponent loggingMessageComponent;

    public AdviceController(LoggingMessageComponent loggingMessageComponent) {
        this.loggingMessageComponent = loggingMessageComponent;
    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException(NotFoundException notFoundException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.NOT_FOUND, notFoundException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + notFoundException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InsufficientFundsException.class)
    public ModelAndView handleInsufficientFundsException(InsufficientFundsException insufficientFundsException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, insufficientFundsException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + insufficientFundsException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InvalidInformationException.class)
    public ModelAndView handleInvalidInformationException(InvalidInformationException invalidInformationException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, invalidInformationException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + invalidInformationException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InvalidMoneyAmountException.class)
    public ModelAndView handleInvalidMoneyAmountException(InvalidMoneyAmountException invalidMoneyAmountException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, invalidMoneyAmountException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + invalidMoneyAmountException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(AlreadyCompletedOperationException.class)
    public ModelAndView handleAlreadyCompletedOperationException(AlreadyCompletedOperationException alreadyCompletedOperationException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.EXPECTATION_FAILED, alreadyCompletedOperationException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + alreadyCompletedOperationException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.BAD_REQUEST, methodArgumentNotValidException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + methodArgumentNotValidException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ModelAndView handleBindException(BindException bindException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.BAD_REQUEST, bindException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + bindException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(InvalidPhoneNumberException.class)
    public ModelAndView handleInvalidPhoneNumberException(InvalidPhoneNumberException invalidPhoneNumberException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.EXPECTATION_FAILED, invalidPhoneNumberException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + invalidPhoneNumberException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(OperationFilterException.class)
    public ModelAndView handleOperationFilterException(OperationFilterException operationFilterException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.EXPECTATION_FAILED, operationFilterException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + operationFilterException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.EXPECTATION_FAILED, illegalArgumentException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + illegalArgumentException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(CreateOperationException.class)
    public ModelAndView handleCreateOperationException(CreateOperationException createOperationException) {
        loggingMessageComponent.logErrorMessage(HttpStatus.EXPECTATION_FAILED, createOperationException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "An error occurred: " + createOperationException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
