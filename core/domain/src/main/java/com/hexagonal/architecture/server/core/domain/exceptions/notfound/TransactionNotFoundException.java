package com.hexagonal.architecture.server.core.domain.exceptions.notfound;

import static com.hexagonal.architecture.server.core.domain.exceptions.utils.ErrorUtils.generateErrorMessage;
import static com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants.TRANSACTION_NOT_FOUND_EXCEPTION;

public class TransactionNotFoundException extends NotFoundException {

    public TransactionNotFoundException(String id) {
        super(generateErrorMessage(TRANSACTION_NOT_FOUND_EXCEPTION, id));
    }
}
