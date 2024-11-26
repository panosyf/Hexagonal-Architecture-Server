package com.hexagonal.server.account.core.domain.service.common.mocks;

import com.hexagonal.server.account.core.domain.service.common.constants.Ids;

public class GetTransactionCommandMocks {

    private GetTransactionCommandMocks() {
    }

    public static GetTransactionCommand generateGetTransactionCommand() {
        return new GetTransactionCommand(Ids.TRANSACTION_ID_1);
    }

}
