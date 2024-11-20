package com.hexagonal.architecture.server.core.domain.service.model.commands;

import com.hexagonal.architecture.server.shared.kernel.valueobjects.Id;

public record GetTransactionCommand(Id id) {
}
