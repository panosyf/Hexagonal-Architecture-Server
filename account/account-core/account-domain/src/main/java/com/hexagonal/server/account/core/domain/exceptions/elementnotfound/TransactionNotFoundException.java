package com.hexagonal.server.account.core.domain.exceptions.elementnotfound;

import com.hexagonal.server.account.core.domain.exceptions.utils.messages.ErrorMessageConstants;
import com.hexagonal.server.shared.kernel.common.exception.types.ElementNotFoundException;
import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;

public class TransactionNotFoundException extends ElementNotFoundException {

    public TransactionNotFoundException(final String id) {
        super(ErrorUtils.generateErrorMessage(ErrorMessageConstants.TRANSACTION_NOT_FOUND_EXCEPTION, id));
    }
}
