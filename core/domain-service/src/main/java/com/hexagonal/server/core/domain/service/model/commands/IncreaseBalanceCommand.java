package com.hexagonal.server.core.domain.service.model.commands;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

public record IncreaseBalanceCommand(Id id, Money amount) {
}
