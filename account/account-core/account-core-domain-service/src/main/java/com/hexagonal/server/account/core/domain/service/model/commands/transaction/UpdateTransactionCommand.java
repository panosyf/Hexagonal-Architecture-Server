package com.hexagonal.server.account.core.domain.service.model.commands.transaction;

import com.hexagonal.server.account.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public record UpdateTransactionCommand(Id id, TransactionStatusEnum transactionStatusEnum) {
}
