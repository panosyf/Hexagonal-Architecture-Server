package com.hexagonal.server.api.model.requests;

import com.hexagonal.server.core.domain.model.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionCreateRequest(
        TransactionType type,
        BigDecimal amount,
        String description,
        String debtorAccountId,
        String beneficiaryAccountId) {
}
