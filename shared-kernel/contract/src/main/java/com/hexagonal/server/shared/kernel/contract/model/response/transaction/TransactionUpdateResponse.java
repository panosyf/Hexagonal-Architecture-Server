package com.hexagonal.server.shared.kernel.contract.model.response.transaction;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionUpdateResponse(String id, String status) {
}
