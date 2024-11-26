package com.hexagonal.server.account.core.domain.service.commands;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

public record IncreaseBalanceCommand(Id id, Money amount) {
}
