package com.hexagonal.architecture.server.api.common.mocks;

import com.hexagonal.architecture.server.api.common.constants.Ids;
import com.hexagonal.architecture.server.core.domain.service.model.commands.IncreaseBalanceCommand;
import com.hexagonal.architecture.server.shared.kernel.valueobjects.Money;

import java.math.BigDecimal;

public class IncreaseBalanceCommandMocks {

    private IncreaseBalanceCommandMocks() {
    }

    public static IncreaseBalanceCommand generateIncreaseBalanceCommand() {
        return new IncreaseBalanceCommand(Ids.ACCOUNT_ID_1, Money.of(BigDecimal.TEN));
    }

}
