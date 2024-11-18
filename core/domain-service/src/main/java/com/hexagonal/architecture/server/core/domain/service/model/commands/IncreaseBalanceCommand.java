package com.hexagonal.architecture.server.core.domain.service.model.commands;

import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

public record IncreaseBalanceCommand(Id id, Money amount) {
}
