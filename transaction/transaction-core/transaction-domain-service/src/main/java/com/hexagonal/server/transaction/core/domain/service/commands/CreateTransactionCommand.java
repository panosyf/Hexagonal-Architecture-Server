package com.hexagonal.server.transaction.core.domain.service.commands;

import com.hexagonal.server.shared.kernel.common.valueobjects.Description;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.transaction.core.domain.enums.TransactionType;

public record CreateTransactionCommand(
        TransactionType type,
        Money amount,
        Description description,
        Id debtorAccountId,
        Id beneficiaryAccountId, TransactionStatusEnum status) {
}
