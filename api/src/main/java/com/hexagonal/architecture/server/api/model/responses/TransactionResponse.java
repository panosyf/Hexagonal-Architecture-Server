package com.hexagonal.architecture.server.api.model.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.architecture.server.api.model.dtos.TransactionDto;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionResponse(TransactionDto transactionDto) {
}
