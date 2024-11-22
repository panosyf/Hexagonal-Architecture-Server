package com.hexagonal.server.application.service.model.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.server.core.domain.model.enums.AccountCreationStatusEnum;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AccountCreationResponse(String id, AccountCreationStatusEnum status) {
}
