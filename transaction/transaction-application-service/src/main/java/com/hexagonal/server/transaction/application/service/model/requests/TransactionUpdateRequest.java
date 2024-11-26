package com.hexagonal.server.transaction.application.service.model.requests;

import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;

public record TransactionUpdateRequest(TransactionStatusEnum transactionStatusEnum) {
}
