package com.hexagonal.architecture.server.core.domain.exceptions.baddata;

import static com.hexagonal.architecture.server.core.domain.exceptions.utils.ErrorUtils.generateErrorMessage;
import static com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants.INSUFFICIENT_BALANCE_EXCEPTION;

public class InsufficientBalanceException extends BadRequestException {

    public InsufficientBalanceException(final String id) {
        super(generateErrorMessage(INSUFFICIENT_BALANCE_EXCEPTION, id));
    }

}
