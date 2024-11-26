package com.hexagonal.server.transaction.application.service.common.mocks;

import com.hexagonal.server.transaction.application.service.common.constants.Ids;
import com.hexagonal.server.transaction.core.domain.service.commands.GetAccountCommand;

public class GetAccountCommandMocks {

    private GetAccountCommandMocks() {
    }

    public static GetAccountCommand generateGetAccountCommand() {
        return new GetAccountCommand(Ids.ACCOUNT_ID_1);
    }

}
