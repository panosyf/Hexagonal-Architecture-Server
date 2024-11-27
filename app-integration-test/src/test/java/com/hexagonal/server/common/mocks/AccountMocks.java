package com.hexagonal.server.common.mocks;

import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.transaction.core.domain.entities.account.Account;
import com.hexagonal.server.transaction.infra.common.constants.Emails;
import com.hexagonal.server.transaction.infra.common.constants.Names;
import com.hexagonal.server.transaction.infra.common.constants.Passwords;
import com.hexagonal.server.transaction.infra.common.constants.Usernames;

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
