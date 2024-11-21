package com.hexagonal.server.core.domain.service.model.commands;

import com.hexagonal.server.shared.kernel.valueobjects.Id;

public record GetAccountCommand(Id id) {
}
