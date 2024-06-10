package com.hexagonal.architecture.server.core.domain.exceptions.notfound;

import static com.hexagonal.architecture.server.core.domain.exceptions.utils.ErrorUtils.generateErrorMessage;
import static com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION;

public class AccountNotFoundException extends NotFoundException {

    public AccountNotFoundException(String id) {
        super(generateErrorMessage(ACCOUNT_NOT_FOUND_EXCEPTION, id));
    }

}
