package com.hexagonal.server.common.mocks;

import com.hexagonal.server.transaction.application.service.model.requests.AccountCreateRequest;
import com.hexagonal.server.transaction.infra.common.constants.Emails;
import com.hexagonal.server.transaction.infra.common.constants.Names;
import com.hexagonal.server.transaction.infra.common.constants.Passwords;
import com.hexagonal.server.transaction.infra.common.constants.Usernames;

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
