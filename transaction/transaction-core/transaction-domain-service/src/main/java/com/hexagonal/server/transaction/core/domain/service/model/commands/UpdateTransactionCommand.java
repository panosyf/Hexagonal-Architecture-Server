package com.hexagonal.server.transaction.core.domain.service.model.commands;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;

public record UpdateTransactionCommand(Id id, TransactionStatusEnum transactionStatusEnum) {
}
