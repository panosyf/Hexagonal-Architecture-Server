package com.hexagonal.server.transaction.core.domain.service.common.mocks;

import com.hexagonal.server.transaction.core.domain.service.commands.GetTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.common.constants.Ids;

public class GetTransactionCommandMocks {

    private GetTransactionCommandMocks() {
    }

    public static GetTransactionCommand generateGetTransactionCommand() {
        return new GetTransactionCommand(Ids.TRANSACTION_ID_1);
    }

}
