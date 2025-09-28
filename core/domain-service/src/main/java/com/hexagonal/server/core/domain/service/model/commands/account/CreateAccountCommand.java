package com.hexagonal.server.core.domain.service.model.commands.account;

import com.hexagonal.server.shared.kernel.common.valueobjects.Email;
import com.hexagonal.server.shared.kernel.common.valueobjects.Name;
import com.hexagonal.server.shared.kernel.common.valueobjects.Password;
import com.hexagonal.server.shared.kernel.common.valueobjects.Username;

public record CreateAccountCommand(Email email, Username username, Password password, Name name) {
}
