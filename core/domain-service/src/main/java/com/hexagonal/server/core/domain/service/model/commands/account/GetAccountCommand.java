package com.hexagonal.server.core.domain.service.model.commands.account;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public record GetAccountCommand(Id id) {
}
