package com.hexagonal.architecture.server.core.domain.common.mocks;

import com.hexagonal.architecture.server.core.domain.common.constants.Emails;
import com.hexagonal.architecture.server.core.domain.common.constants.Names;
import com.hexagonal.architecture.server.core.domain.common.constants.Passwords;
import com.hexagonal.architecture.server.core.domain.common.constants.Usernames;
import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

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
