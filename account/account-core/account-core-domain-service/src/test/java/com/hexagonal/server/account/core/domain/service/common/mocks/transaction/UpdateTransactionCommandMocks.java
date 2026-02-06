package com.hexagonal.server.account.core.domain.service.common.mocks.transaction;

import com.hexagonal.server.account.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.account.core.domain.service.common.constants.transaction.Ids;
import com.hexagonal.server.account.core.domain.service.model.commands.transaction.UpdateTransactionCommand;

public class UpdateTransactionCommandMocks {

    private UpdateTransactionCommandMocks() {
    }

    public static UpdateTransactionCommand generateUpdateTransactionCommand() {
        return new UpdateTransactionCommand(Ids.TRANSACTION_ID_1, TransactionStatusEnum.COMPLETED);
    }

}
