package com.hexagonal.server.account.application.service.model.requests;

import com.hexagonal.server.account.core.domain.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionCreateRequest(
        TransactionType type,
        BigDecimal amount,
        String description,
        String debtorAccountId,
        String beneficiaryAccountId) {
}
