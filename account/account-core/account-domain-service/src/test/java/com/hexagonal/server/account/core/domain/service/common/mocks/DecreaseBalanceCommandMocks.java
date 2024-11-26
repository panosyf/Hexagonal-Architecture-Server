package com.hexagonal.server.account.core.domain.service.common.mocks;

import com.hexagonal.server.account.core.domain.service.commands.DecreaseBalanceCommand;
import com.hexagonal.server.account.core.domain.service.common.constants.Ids;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

import java.math.BigDecimal;

public class DecreaseBalanceCommandMocks {

    private DecreaseBalanceCommandMocks() {
    }

    public static DecreaseBalanceCommand generateDecreaseBalanceCommand() {
        return new DecreaseBalanceCommand(Ids.ACCOUNT_ID_1, Money.of(BigDecimal.TEN));
    }

}
