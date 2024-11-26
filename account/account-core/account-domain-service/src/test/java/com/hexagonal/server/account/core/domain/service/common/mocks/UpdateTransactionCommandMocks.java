package com.hexagonal.server.account.core.domain.service.common.mocks;

import com.hexagonal.server.account.core.domain.service.common.constants.Ids;

public class UpdateTransactionCommandMocks {

    private UpdateTransactionCommandMocks() {
    }

    public static UpdateTransactionCommand generateUpdateTransactionCommand() {
        return new UpdateTransactionCommand(Ids.TRANSACTION_ID_1, TransactionStatusEnum.COMPLETED);
    }

}
