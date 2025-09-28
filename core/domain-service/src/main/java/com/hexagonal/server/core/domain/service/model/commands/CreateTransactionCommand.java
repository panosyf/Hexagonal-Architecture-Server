package com.hexagonal.server.core.domain.service.model.commands;

import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.core.domain.model.enums.transaction.TransactionType;
import com.hexagonal.server.shared.kernel.common.valueobjects.Description;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

public record CreateTransactionCommand(
        TransactionType type,
        Money amount,
        Description description,
        Id debtorAccountId,
        Id beneficiaryAccountId, TransactionStatusEnum status) {
}
