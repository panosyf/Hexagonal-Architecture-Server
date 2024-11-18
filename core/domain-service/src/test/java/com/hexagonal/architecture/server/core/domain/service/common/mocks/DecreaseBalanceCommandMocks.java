package com.hexagonal.architecture.server.core.domain.service.common.mocks;

import com.hexagonal.architecture.server.core.domain.model.constants.Amount;
import com.hexagonal.architecture.server.core.domain.service.common.constants.Ids;
import com.hexagonal.architecture.server.core.domain.service.model.commands.DecreaseBalanceCommand;

public class DecreaseBalanceCommandMocks {

    private DecreaseBalanceCommandMocks() {
    }

    public static DecreaseBalanceCommand generateDecreaseBalanceCommand() {
        return new DecreaseBalanceCommand(Ids.ACCOUNT_ID_1, Amount.AMOUNT_10);
    }

}
