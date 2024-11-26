package com.hexagonal.server.transaction.core.domain.service.common.mocks;

import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.transaction.core.domain.service.commands.DecreaseBalanceCommand;
import com.hexagonal.server.transaction.core.domain.service.common.constants.Ids;

import java.math.BigDecimal;

public class DecreaseBalanceCommandMocks {

    private DecreaseBalanceCommandMocks() {
    }

    public static DecreaseBalanceCommand generateDecreaseBalanceCommand() {
        return new DecreaseBalanceCommand(Ids.ACCOUNT_ID_1, Money.of(BigDecimal.TEN));
    }

}
