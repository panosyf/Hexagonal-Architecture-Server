package com.hexagonal.architecture.server.core.domain.service.model.requests;

import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionCreateRequest(
        TransactionType transactionType,
        BigDecimal amount,
        String description,
        String debtorAccountId,
        String beneficiaryAccountId) {
}
