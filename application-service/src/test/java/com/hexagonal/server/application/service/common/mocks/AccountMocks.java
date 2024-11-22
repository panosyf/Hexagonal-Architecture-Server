package com.hexagonal.server.application.service.common.mocks;

import com.hexagonal.server.application.service.common.constants.Emails;
import com.hexagonal.server.application.service.common.constants.Names;
import com.hexagonal.server.application.service.common.constants.Passwords;
import com.hexagonal.server.application.service.common.constants.Usernames;
import com.hexagonal.server.core.domain.domains.account.Account;
import com.hexagonal.server.shared.kernel.valueobjects.Money;

public class AccountMocks {

    private AccountMocks() {
    }

    public static Account generateAccount() {
        return new Account(
                Emails.EMAIL_1,
                Usernames.USERNAME_1,
                Passwords.PASSWORD_1,
                Names.ACCOUNT_NAME_1);
    }

    public static Account generateAccount(Money balance) {
        return new Account(
                Emails.EMAIL_1,
                Usernames.USERNAME_1,
                Passwords.PASSWORD_1,
                Names.ACCOUNT_NAME_1,
                balance);
    }

}
