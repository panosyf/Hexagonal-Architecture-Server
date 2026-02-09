package com.hexagonal.server.infra.common.mocks.account;

import com.hexagonal.server.account.core.domain.entities.account.Account;
import com.hexagonal.server.infra.common.constants.account.Emails;
import com.hexagonal.server.infra.common.constants.account.Names;
import com.hexagonal.server.infra.common.constants.account.Passwords;
import com.hexagonal.server.infra.common.constants.account.Usernames;
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
