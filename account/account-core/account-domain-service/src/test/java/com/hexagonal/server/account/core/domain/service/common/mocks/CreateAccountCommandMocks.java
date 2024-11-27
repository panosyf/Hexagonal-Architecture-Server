package com.hexagonal.server.account.core.domain.service.common.mocks;

import com.hexagonal.server.account.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.server.account.core.domain.service.common.constants.Emails;
import com.hexagonal.server.account.core.domain.service.common.constants.Names;
import com.hexagonal.server.account.core.domain.service.common.constants.Passwords;
import com.hexagonal.server.account.core.domain.service.common.constants.Usernames;

public class CreateAccountCommandMocks {

    private CreateAccountCommandMocks() {
    }

    public static CreateAccountCommand generateCreateAccountCommand() {
        return new CreateAccountCommand(
                Emails.EMAIL_1,
                Usernames.USERNAME_1,
                Passwords.PASSWORD_1,
                Names.ACCOUNT_NAME_1);
    }

}