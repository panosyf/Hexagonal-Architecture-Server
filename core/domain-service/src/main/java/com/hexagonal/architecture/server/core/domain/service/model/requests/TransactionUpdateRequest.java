package com.hexagonal.architecture.server.core.domain.service.model.requests;

import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;

public record TransactionUpdateRequest(TransactionStatusEnum transactionStatusEnum) {
}
