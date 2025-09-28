package com.hexagonal.server.core.domain.service.common.mocks.account;

import com.hexagonal.server.core.domain.service.common.constants.account.Ids;
import com.hexagonal.server.core.domain.service.model.commands.account.IncreaseBalanceCommand;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

import java.math.BigDecimal;

public class IncreaseBalanceCommandMocks {

    private IncreaseBalanceCommandMocks() {
    }

    public static IncreaseBalanceCommand generateIncreaseBalanceCommand() {
        return new IncreaseBalanceCommand(Ids.ACCOUNT_ID_1, Money.of(BigDecimal.TEN));
    }

}
