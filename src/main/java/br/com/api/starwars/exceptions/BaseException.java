package br.com.api.starwars.exceptions;

import br.com.api.starwars.enums.ErrorCodeEnum;
import br.com.api.starwars.enums.ErrorMessages;
import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private ErrorCodeEnum errorCodeEnum;
    private ErrorMessages errorMessages;

    public BaseException(
            final ErrorCodeEnum errorCodeEnum,
            final ErrorMessages errorMessages,
            final String message) {
        super(message);
        this.errorCodeEnum = errorCodeEnum;
        this.errorMessages = errorMessages;
    }

    public String getErrorMessage() {
        return errorMessages.getMessage();
    }

    public HttpStatus getHttpStatus() {
        return errorMessages.getHttpStatus();
    }
}
