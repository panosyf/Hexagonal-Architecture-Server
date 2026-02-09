package com.hexagonal.server.account.application.model.responses.transaction;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.server.account.core.domain.model.enums.transaction.TransactionStatusEnum;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionCreationResponse(String id, TransactionStatusEnum status) {
}