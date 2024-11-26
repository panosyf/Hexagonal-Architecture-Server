package com.hexagonal.server.transaction.core.domain.exceptions.elementnotfound;

import com.hexagonal.server.shared.kernel.common.exception.types.ElementNotFoundException;
import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;
import com.hexagonal.server.transaction.core.domain.exceptions.utils.messages.ErrorMessageConstants;

public class TransactionNotFoundException extends ElementNotFoundException {

    public TransactionNotFoundException(final String id) {
        super(ErrorUtils.generateErrorMessage(ErrorMessageConstants.TRANSACTION_NOT_FOUND_EXCEPTION, id));
    }
}
