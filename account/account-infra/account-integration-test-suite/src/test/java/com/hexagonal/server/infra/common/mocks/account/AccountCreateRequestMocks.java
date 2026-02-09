package com.hexagonal.server.infra.common.mocks.account;

import com.hexagonal.server.account.application.service.model.requests.account.AccountCreateRequest;
import com.hexagonal.server.infra.common.constants.account.Emails;
import com.hexagonal.server.infra.common.constants.account.Names;
import com.hexagonal.server.infra.common.constants.account.Passwords;
import com.hexagonal.server.infra.common.constants.account.Usernames;

public class AccountCreateRequestMocks {

    private AccountCreateRequestMocks() {
    }

    public static AccountCreateRequest generateAccountCreateRequest() {
        return new AccountCreateRequest(
                Emails.EMAIL_1.getValue(),
                Usernames.USERNAME_1.getValue(),
                Passwords.PASSWORD_1.getValue(),
                Names.ACCOUNT_NAME_1.getFirstName(),
                Names.ACCOUNT_NAME_1.getLastName());
    }

}
