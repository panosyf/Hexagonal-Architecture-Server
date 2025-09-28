package com.hexagonal.server.core.domain.exceptions.illegalargument.transaction;

import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;

import static com.hexagonal.server.core.domain.exceptions.utils.messages.transaction.ErrorMessageConstants.INSUFFICIENT_BALANCE_EXCEPTION;

public class InsufficientBalanceException extends IllegalArgumentException {

    public InsufficientBalanceException(final String id) {
        super(ErrorUtils.generateErrorMessage(INSUFFICIENT_BALANCE_EXCEPTION, id));
    }

}
