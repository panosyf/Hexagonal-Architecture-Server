package com.hexagonal.server.account.core.domain.service.model.commands.transaction;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public record GetTransactionCommand(Id id) {
}
