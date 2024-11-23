package com.hexagonal.server.core.domain.service.model.commands;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public record GetAccountCommand(Id id) {
}
