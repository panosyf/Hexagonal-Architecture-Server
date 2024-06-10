package com.hexagonal.architecture.server.api.model.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.architecture.server.core.domain.model.enums.AccountCreationStatusEnum;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AccountCreationResponse(AccountCreationStatusEnum status) {
}
