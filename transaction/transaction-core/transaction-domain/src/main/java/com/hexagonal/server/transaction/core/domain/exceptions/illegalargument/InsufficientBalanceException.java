package com.hexagonal.server.transaction.core.domain.exceptions.illegalargument;

import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;
import com.hexagonal.server.transaction.core.domain.exceptions.utils.messages.ErrorMessageConstants;

public class InsufficientBalanceException extends IllegalArgumentException {

    public InsufficientBalanceException(final String id) {
        super(ErrorUtils.generateErrorMessage(ErrorMessageConstants.INSUFFICIENT_BALANCE_EXCEPTION, id));
    }

}
