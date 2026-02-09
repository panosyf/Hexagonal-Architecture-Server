package com.hexagonal.server.account.application.model.responses.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hexagonal.server.account.application.model.dtos.account.AccountDto;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AccountResponse(AccountDto accountDto) {
}
