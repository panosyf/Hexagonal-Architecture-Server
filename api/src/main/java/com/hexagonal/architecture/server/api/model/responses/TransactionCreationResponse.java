package com.hexagonal.architecture.server.api.model.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionCreationResponse(TransactionStatusEnum status, String transactionId) {
}