package com.hexagonal.architecture.server.core.domain.service.model.commands;

import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;
import com.hexagonal.architecture.server.core.domain.valueobjects.Description;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

public record CreateTransactionCommand(TransactionType type, Money amount, Description description, Id debtorAccountId,
                                       Id beneficiaryAccountId, TransactionStatusEnum status) {
}
