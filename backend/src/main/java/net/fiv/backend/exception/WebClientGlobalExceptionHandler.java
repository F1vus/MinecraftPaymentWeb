package net.fiv.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class WebClientGlobalExceptionHandler {

    @ExceptionHandler(value = InsufficientFundsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorResponse insufficientFundsResponseException(InsufficientFundsException exception) {
        return new ErrorResponse(HttpStatus.FORBIDDEN.value(), exception.getMessage());
    }

    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody ErrorResponse authenticationException(AuthenticationException exception) {
        return new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }

    @ExceptionHandler(value = NoSuchExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse noSuchExistsException(NoSuchExistsException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(value = AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse alreadyExistsException(AlreadyExistsException exception) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
    }

}
