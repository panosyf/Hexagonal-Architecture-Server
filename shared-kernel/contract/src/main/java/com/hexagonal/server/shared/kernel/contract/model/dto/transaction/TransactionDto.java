package com.hexagonal.server.shared.kernel.contract.model.dto.transaction;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.time.Instant;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionDto(
        String id,
        String type,
        BigDecimal amount,
        String description,
        String debtorAccountId,
        String beneficiaryAccountId,
        String status,
        Instant createdAt,
        Instant updatedAt) {
}
