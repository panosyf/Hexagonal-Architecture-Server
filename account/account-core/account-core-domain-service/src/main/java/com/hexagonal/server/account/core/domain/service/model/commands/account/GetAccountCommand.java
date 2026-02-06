package com.hexagonal.server.account.core.domain.service.model.commands.account;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public record GetAccountCommand(Id id) {
}
