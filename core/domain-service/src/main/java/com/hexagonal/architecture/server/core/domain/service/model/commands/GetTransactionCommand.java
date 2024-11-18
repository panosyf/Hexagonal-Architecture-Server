package com.hexagonal.architecture.server.core.domain.service.model.commands;

import com.hexagonal.architecture.server.core.domain.valueobjects.Id;

public record GetTransactionCommand(Id id) {
}
