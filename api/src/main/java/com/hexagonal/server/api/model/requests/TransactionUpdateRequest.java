package com.hexagonal.server.api.model.requests;

import com.hexagonal.server.core.domain.model.enums.TransactionStatusEnum;

public record TransactionUpdateRequest(TransactionStatusEnum transactionStatusEnum) {
}
