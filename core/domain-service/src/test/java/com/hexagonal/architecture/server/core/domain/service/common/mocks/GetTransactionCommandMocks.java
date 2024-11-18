package com.hexagonal.architecture.server.core.domain.service.common.mocks;

import com.hexagonal.architecture.server.core.domain.service.common.constants.Ids;
import com.hexagonal.architecture.server.core.domain.service.model.commands.GetTransactionCommand;

public class GetTransactionCommandMocks {

    private GetTransactionCommandMocks() {
    }

    public static GetTransactionCommand generateGetTransactionCommand() {
        return new GetTransactionCommand(Ids.TRANSACTION_ID_1);
    }

}
