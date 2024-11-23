package com.hexagonal.server.core.domain.service.common.mocks;

import com.hexagonal.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.server.core.domain.model.enums.TransactionType;
import com.hexagonal.server.core.domain.service.common.constants.Ids;
import com.hexagonal.server.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.shared.kernel.common.valueobjects.Description;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

import java.math.BigDecimal;

public class CreateTransactionCommandMocks {

    private CreateTransactionCommandMocks() {
    }

    public static CreateTransactionCommand generateCreateTransactionCommand() {
        return new CreateTransactionCommand(
                TransactionType.TRANSFER,
                Money.of(BigDecimal.valueOf(5)),
                Description.emptyDescription(),
                Ids.ACCOUNT_ID_1,
                Ids.ACCOUNT_ID_2,
                TransactionStatusEnum.PENDING
        );
    }

}
