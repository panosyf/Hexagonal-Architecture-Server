package com.hexagonal.server.application.service.model.requests.transaction;

import com.hexagonal.server.core.domain.model.enums.transaction.TransactionType;

import java.math.BigDecimal;

public record TransactionCreateRequest(
        TransactionType type,
        BigDecimal amount,
        String description,
        String debtorAccountId,
        String beneficiaryAccountId) {
}
