package com.hexagonal.server.shared.kernel.contract.model.response.transaction;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.server.shared.kernel.contract.model.dto.transaction.TransactionDto;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionResponse(TransactionDto transactionDto) {
}
