package com.hexagonal.server.core.domain.common.mocks;

import com.hexagonal.server.core.domain.common.constants.Emails;
import com.hexagonal.server.core.domain.common.constants.Names;
import com.hexagonal.server.core.domain.common.constants.Passwords;
import com.hexagonal.server.core.domain.common.constants.Usernames;
import com.hexagonal.server.core.domain.entities.account.Account;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

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
