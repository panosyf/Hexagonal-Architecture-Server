package com.hexagonal.server.shared.kernel.contract.model.request.transaction;

import java.math.BigDecimal;

public record TransactionCreateRequest(
        String type,
        BigDecimal amount,
        String description,
        String debtorAccountId,
        String beneficiaryAccountId) {
}
