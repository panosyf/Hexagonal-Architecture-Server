package com.hexagonal.server.application.service.model.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.server.application.service.model.dtos.AccountDto;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AccountResponse(AccountDto accountDto) {
}
