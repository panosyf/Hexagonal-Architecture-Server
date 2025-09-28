package com.hexagonal.server.application.service.model.responses.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.server.core.domain.model.enums.account.AccountCreationStatusEnum;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AccountCreationResponse(String id, AccountCreationStatusEnum status) {
}
