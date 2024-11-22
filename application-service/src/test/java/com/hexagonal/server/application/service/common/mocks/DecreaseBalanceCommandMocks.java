package com.hexagonal.server.application.service.common.mocks;

import com.hexagonal.server.application.service.common.constants.Ids;
import com.hexagonal.server.core.domain.service.model.commands.DecreaseBalanceCommand;
import com.hexagonal.server.shared.kernel.valueobjects.Money;

import java.math.BigDecimal;

public class DecreaseBalanceCommandMocks {

    private DecreaseBalanceCommandMocks() {
    }

    public static DecreaseBalanceCommand generateDecreaseBalanceCommand() {
        return new DecreaseBalanceCommand(Ids.ACCOUNT_ID_1, Money.of(BigDecimal.TEN));
    }

}
