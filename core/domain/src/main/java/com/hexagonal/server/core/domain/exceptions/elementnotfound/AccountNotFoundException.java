package com.hexagonal.server.core.domain.exceptions.elementnotfound;

import com.hexagonal.server.shared.kernel.common.exception.types.ElementNotFoundException;
import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;

import static com.hexagonal.server.core.domain.exceptions.utils.messages.ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION;

public class AccountNotFoundException extends ElementNotFoundException {

    public AccountNotFoundException(final String id) {
        super(ErrorUtils.generateErrorMessage(ACCOUNT_NOT_FOUND_EXCEPTION, id));
    }

}
