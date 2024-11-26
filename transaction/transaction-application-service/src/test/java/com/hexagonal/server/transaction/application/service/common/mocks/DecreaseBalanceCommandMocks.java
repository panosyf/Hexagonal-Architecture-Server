package com.hexagonal.server.transaction.application.service.common.mocks;

import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.transaction.application.service.common.constants.Ids;
import com.hexagonal.server.transaction.core.domain.service.commands.DecreaseBalanceCommand;

import java.math.BigDecimal;

public class DecreaseBalanceCommandMocks {

    private DecreaseBalanceCommandMocks() {
    }

    public static DecreaseBalanceCommand generateDecreaseBalanceCommand() {
        return new DecreaseBalanceCommand(Ids.ACCOUNT_ID_1, Money.of(BigDecimal.TEN));
    }

}
