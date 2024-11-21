package com.hexagonal.server.core.domain.exceptions.elementnotfound;

import com.hexagonal.server.shared.kernel.exception.types.ElementNotFoundException;
import com.hexagonal.server.shared.kernel.exception.utils.ErrorUtils;

import static com.hexagonal.server.core.domain.exceptions.utils.messages.ErrorMessageConstants.TRANSACTION_NOT_FOUND_EXCEPTION;

public class TransactionNotFoundException extends ElementNotFoundException {

    public TransactionNotFoundException(final String id) {
        super(ErrorUtils.generateErrorMessage(TRANSACTION_NOT_FOUND_EXCEPTION, id));
    }
}
