package com.hexagonal.architecture.server.core.domain.service.model.commands;

import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

public record DecreaseBalanceCommand(Id id, Money amount) {
}
