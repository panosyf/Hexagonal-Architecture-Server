package com.hexagonal.server.core.domain.service.common.mocks;

import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.core.domain.service.common.constants.Ids;
import com.hexagonal.server.core.domain.service.model.commands.UpdateTransactionCommand;

public class UpdateTransactionCommandMocks {

    private UpdateTransactionCommandMocks() {
    }

    public static UpdateTransactionCommand generateUpdateTransactionCommand() {
        return new UpdateTransactionCommand(Ids.TRANSACTION_ID_1, TransactionStatusEnum.COMPLETED);
    }

}
