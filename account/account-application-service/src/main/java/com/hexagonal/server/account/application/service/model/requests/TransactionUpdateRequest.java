package com.hexagonal.server.account.application.service.model.requests;

import com.hexagonal.server.account.core.domain.enums.TransactionStatusEnum;

public record TransactionUpdateRequest(TransactionStatusEnum transactionStatusEnum) {
}
