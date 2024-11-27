package com.hexagonal.server.transaction.application.service.model.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.server.transaction.application.service.model.dtos.TransactionDto;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionResponse(TransactionDto transactionDto) {
}