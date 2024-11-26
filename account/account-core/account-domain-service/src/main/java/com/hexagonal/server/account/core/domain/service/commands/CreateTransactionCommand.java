package com.hexagonal.server.account.core.domain.service.commands;

import com.hexagonal.server.account.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.account.core.domain.enums.TransactionType;
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
