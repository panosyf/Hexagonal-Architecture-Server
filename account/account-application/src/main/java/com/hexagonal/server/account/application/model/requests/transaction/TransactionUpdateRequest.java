package com.hexagonal.server.account.application.model.requests.transaction;

import com.hexagonal.server.account.core.domain.model.enums.transaction.TransactionStatusEnum;

public record TransactionUpdateRequest(TransactionStatusEnum transactionStatusEnum) {
}
