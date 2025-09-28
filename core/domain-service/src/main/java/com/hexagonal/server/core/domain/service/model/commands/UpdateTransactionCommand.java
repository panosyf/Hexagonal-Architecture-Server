package com.hexagonal.server.core.domain.service.model.commands;

import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public record UpdateTransactionCommand(Id id, TransactionStatusEnum transactionStatusEnum) {
}
