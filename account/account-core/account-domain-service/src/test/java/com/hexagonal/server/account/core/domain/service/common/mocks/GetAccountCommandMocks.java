package com.hexagonal.server.account.core.domain.service.common.mocks;

import com.hexagonal.server.account.core.domain.service.commands.GetAccountCommand;
import com.hexagonal.server.account.core.domain.service.common.constants.Ids;

public class GetAccountCommandMocks {

    private GetAccountCommandMocks() {}

    public static GetAccountCommand generateGetAccountCommand() {
        return new GetAccountCommand(Ids.ACCOUNT_ID_1);
    }

}
