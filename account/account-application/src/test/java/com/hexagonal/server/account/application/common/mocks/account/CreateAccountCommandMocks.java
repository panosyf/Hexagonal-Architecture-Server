package com.hexagonal.server.account.application.common.mocks.account;

import com.hexagonal.server.account.application.common.constants.account.Emails;
import com.hexagonal.server.account.application.common.constants.account.Names;
import com.hexagonal.server.account.application.common.constants.account.Passwords;
import com.hexagonal.server.account.application.common.constants.account.Usernames;
import com.hexagonal.server.account.core.domain.service.model.commands.account.CreateAccountCommand;

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
