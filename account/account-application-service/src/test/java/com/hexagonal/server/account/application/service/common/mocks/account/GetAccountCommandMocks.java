package com.hexagonal.server.account.application.service.common.mocks.account;


import com.hexagonal.server.account.application.service.common.constants.account.Ids;
import com.hexagonal.server.account.core.domain.service.model.commands.account.GetAccountCommand;

public class GetAccountCommandMocks {

    private GetAccountCommandMocks() {
    }

    public static GetAccountCommand generateGetAccountCommand() {
        return new GetAccountCommand(Ids.ACCOUNT_ID_1);
    }

}
