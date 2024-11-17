package com.hexagonal.architecture.server.core.domain.service.model.commands;

import com.hexagonal.architecture.server.core.domain.valueobjects.Email;
import com.hexagonal.architecture.server.core.domain.valueobjects.Name;
import com.hexagonal.architecture.server.core.domain.valueobjects.Password;
import com.hexagonal.architecture.server.core.domain.valueobjects.Username;

public record CreateAccountCommand(Email email, Username username, Password password, Name name) {
}
