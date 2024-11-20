package com.hexagonal.architecture.server.core.domain.exceptions.illegalargument;

import com.hexagonal.architecture.server.shared.kernel.exception.utils.ErrorUtils;

import static com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants.INSUFFICIENT_BALANCE_EXCEPTION;

public class InsufficientBalanceException extends IllegalArgumentException {

    public InsufficientBalanceException(final String id) {
        super(ErrorUtils.generateErrorMessage(INSUFFICIENT_BALANCE_EXCEPTION, id));
    }

}
