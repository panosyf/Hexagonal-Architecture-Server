package com.hexagonal.server.account.infra.common.mocks;

import com.hexagonal.server.account.application.service.model.requests.AccountCreateRequest;
import com.hexagonal.server.account.infra.common.constants.Emails;
import com.hexagonal.server.account.infra.common.constants.Names;
import com.hexagonal.server.account.infra.common.constants.Passwords;
import com.hexagonal.server.account.infra.common.constants.Usernames;

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
