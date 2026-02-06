package com.hexagonal.server.account.core.domain.service.model.commands.account;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

public record DecreaseBalanceCommand(Id id, Money amount) {
}
