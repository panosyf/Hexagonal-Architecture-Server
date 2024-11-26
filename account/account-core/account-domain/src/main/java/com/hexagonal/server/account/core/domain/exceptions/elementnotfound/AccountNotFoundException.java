package com.hexagonal.server.account.core.domain.exceptions.elementnotfound;

import com.hexagonal.server.account.core.domain.exceptions.utils.messages.ErrorMessageConstants;
import com.hexagonal.server.shared.kernel.common.exception.types.ElementNotFoundException;
import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;


public class AccountNotFoundException extends ElementNotFoundException {

    public AccountNotFoundException(final String id) {
        super(ErrorUtils.generateErrorMessage(ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION, id));
    }

}
