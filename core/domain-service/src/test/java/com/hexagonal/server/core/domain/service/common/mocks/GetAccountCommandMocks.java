package com.hexagonal.server.core.domain.service.common.mocks;

import com.hexagonal.server.core.domain.service.common.constants.Ids;
import com.hexagonal.server.core.domain.service.model.commands.GetAccountCommand;

public class GetAccountCommandMocks {

    private GetAccountCommandMocks() {}

    public static GetAccountCommand generateGetAccountCommand() {
        return new GetAccountCommand(Ids.ACCOUNT_ID_1);
    }

}
