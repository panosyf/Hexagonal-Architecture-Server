package com.hexagonal.server.application.service.model.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.server.core.domain.model.enums.TransactionStatusEnum;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TransactionUpdateResponse(String id, TransactionStatusEnum status) {
}
