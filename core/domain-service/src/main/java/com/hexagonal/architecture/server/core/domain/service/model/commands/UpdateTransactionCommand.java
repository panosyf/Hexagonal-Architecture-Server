package com.hexagonal.architecture.server.core.domain.service.model.commands;

import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;

public record UpdateTransactionCommand(Id id, TransactionStatusEnum transactionStatusEnum) {
}
