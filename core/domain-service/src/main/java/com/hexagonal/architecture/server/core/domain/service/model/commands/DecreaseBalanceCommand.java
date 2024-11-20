package com.hexagonal.architecture.server.core.domain.service.model.commands;

import com.hexagonal.architecture.server.shared.kernel.valueobjects.Id;
import com.hexagonal.architecture.server.shared.kernel.valueobjects.Money;

public record DecreaseBalanceCommand(Id id, Money amount) {
}
