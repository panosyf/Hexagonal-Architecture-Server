package com.hexagonal.server.transaction.core.domain.service.commands;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public record GetTransactionCommand(Id id) {
}
