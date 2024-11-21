package com.hexagonal.server.core.domain.service.model.commands;

import com.hexagonal.server.shared.kernel.valueobjects.Id;
import com.hexagonal.server.shared.kernel.valueobjects.Money;

public record IncreaseBalanceCommand(Id id, Money amount) {
}
