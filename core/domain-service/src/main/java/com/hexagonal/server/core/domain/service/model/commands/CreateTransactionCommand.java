package com.hexagonal.server.core.domain.service.model.commands;

import com.hexagonal.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.server.core.domain.model.enums.TransactionType;
import com.hexagonal.server.shared.kernel.valueobjects.Description;
import com.hexagonal.server.shared.kernel.valueobjects.Id;
import com.hexagonal.server.shared.kernel.valueobjects.Money;

public record CreateTransactionCommand(
        TransactionType type,
        Money amount,
        Description description,
        Id debtorAccountId,
        Id beneficiaryAccountId, TransactionStatusEnum status) {
}