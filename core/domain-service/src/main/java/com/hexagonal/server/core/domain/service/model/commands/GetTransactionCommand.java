package com.hexagonal.server.core.domain.service.model.commands;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public record GetTransactionCommand(Id id) {
}
