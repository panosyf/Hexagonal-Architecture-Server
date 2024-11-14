package com.hexagonal.architecture.server.api.model.requests;

import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionCreateRequest(
        TransactionType type,
        BigDecimal amount,
        String description,
        String debtorAccountId,
        String beneficiaryAccountId) {
}
