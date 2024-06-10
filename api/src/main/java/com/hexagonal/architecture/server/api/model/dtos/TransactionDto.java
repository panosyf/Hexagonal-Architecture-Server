package com.hexagonal.architecture.server.api.model.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionDto(
        TransactionType type,
        BigDecimal amount,
        String description,
        String debtorAccountId,
        String beneficiaryAccountId,
        TransactionStatusEnum status,
        Instant createdAt,
        Instant updatedAt) {
}
