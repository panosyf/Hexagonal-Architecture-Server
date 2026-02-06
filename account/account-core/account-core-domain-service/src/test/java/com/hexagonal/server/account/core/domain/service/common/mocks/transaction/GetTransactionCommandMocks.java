package com.hexagonal.server.account.core.domain.service.common.mocks.transaction;

import com.hexagonal.server.account.core.domain.service.common.constants.transaction.Ids;
import com.hexagonal.server.account.core.domain.service.model.commands.transaction.GetTransactionCommand;

public class GetTransactionCommandMocks {

    private GetTransactionCommandMocks() {
    }

    public static GetTransactionCommand generateGetTransactionCommand() {
        return new GetTransactionCommand(Ids.TRANSACTION_ID_1);
    }

}
