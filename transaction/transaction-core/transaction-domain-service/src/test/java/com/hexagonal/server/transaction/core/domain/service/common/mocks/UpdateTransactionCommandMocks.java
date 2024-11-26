package com.hexagonal.server.transaction.core.domain.service.common.mocks;

import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.transaction.core.domain.service.commands.UpdateTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.common.constants.Ids;

public class UpdateTransactionCommandMocks {

    private UpdateTransactionCommandMocks() {
    }

    public static UpdateTransactionCommand generateUpdateTransactionCommand() {
        return new UpdateTransactionCommand(Ids.TRANSACTION_ID_1, TransactionStatusEnum.COMPLETED);
    }

}
