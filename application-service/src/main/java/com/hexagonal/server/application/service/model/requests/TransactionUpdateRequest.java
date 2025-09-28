package com.hexagonal.server.application.service.model.requests;

import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;

public record TransactionUpdateRequest(TransactionStatusEnum transactionStatusEnum) {
}
