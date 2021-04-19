package br.com.api.starwars.exceptions;

import br.com.api.starwars.enums.ErrorMessages;
import br.com.api.starwars.enums.ErrorCodeEnum;

public class PlanetException extends BaseException {

    public PlanetException(
            final ErrorCodeEnum errorCodeEnum,
            final ErrorMessages errorMessages,
            final String message) {
        super(errorCodeEnum, errorMessages, message);
    }
}
