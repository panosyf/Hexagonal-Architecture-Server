package com.hexagonal.server.account.core.domain.exceptions.illegalargument;

import com.hexagonal.server.account.core.domain.exceptions.utils.messages.ErrorMessageConstants;
import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;

public class InsufficientBalanceException extends IllegalArgumentException {

    public InsufficientBalanceException(final String id) {
        super(ErrorUtils.generateErrorMessage(ErrorMessageConstants.INSUFFICIENT_BALANCE_EXCEPTION, id));
    }

}
