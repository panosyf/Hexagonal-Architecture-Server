package com.hexagonal.architecture.server.core.domain.service.common.mocks;

import com.hexagonal.architecture.server.core.domain.model.constants.Amount;
import com.hexagonal.architecture.server.core.domain.service.common.constants.Ids;
import com.hexagonal.architecture.server.core.domain.service.model.commands.IncreaseBalanceCommand;

public class IncreaseBalanceCommandMocks {

    private IncreaseBalanceCommandMocks() {
    }

    public static IncreaseBalanceCommand generateIncreaseBalanceCommand() {
        return new IncreaseBalanceCommand(Ids.ACCOUNT_ID_1, Amount.AMOUNT_10);
    }

}
