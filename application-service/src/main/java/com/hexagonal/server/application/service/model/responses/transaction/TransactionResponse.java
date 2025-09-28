package com.hexagonal.server.application.service.model.responses.transaction;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.server.application.service.model.dtos.transaction.TransactionDto;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionResponse(TransactionDto transactionDto) {
}
