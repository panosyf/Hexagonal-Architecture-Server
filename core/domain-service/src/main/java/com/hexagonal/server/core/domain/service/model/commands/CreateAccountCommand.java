package com.hexagonal.server.core.domain.service.model.commands;

import com.hexagonal.server.shared.kernel.valueobjects.Email;
import com.hexagonal.server.shared.kernel.valueobjects.Name;
import com.hexagonal.server.shared.kernel.valueobjects.Password;
import com.hexagonal.server.shared.kernel.valueobjects.Username;

public record CreateAccountCommand(Email email, Username username, Password password, Name name) {
}
