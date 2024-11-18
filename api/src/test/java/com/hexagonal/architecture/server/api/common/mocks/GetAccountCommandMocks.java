package com.hexagonal.architecture.server.api.common.mocks;


import com.hexagonal.architecture.server.api.common.constants.Ids;
import com.hexagonal.architecture.server.core.domain.service.model.commands.GetAccountCommand;

public class GetAccountCommandMocks {

    private GetAccountCommandMocks() {
    }

    public static GetAccountCommand generateGetAccountCommand() {
        return new GetAccountCommand(Ids.ACCOUNT_ID_1);
    }

}
