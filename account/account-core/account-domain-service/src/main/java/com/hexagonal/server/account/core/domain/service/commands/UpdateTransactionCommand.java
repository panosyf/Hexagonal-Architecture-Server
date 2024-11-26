package com.hexagonal.server.account.core.domain.service.commands;

import com.hexagonal.server.account.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public record UpdateTransactionCommand(Id id, TransactionStatusEnum transactionStatusEnum) {
}
