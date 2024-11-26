package com.hexagonal.server.transaction.application.service.common.mocks;

import com.hexagonal.server.transaction.application.service.common.constants.Emails;
import com.hexagonal.server.transaction.application.service.common.constants.Names;
import com.hexagonal.server.transaction.application.service.common.constants.Passwords;
import com.hexagonal.server.transaction.application.service.common.constants.Usernames;
import com.hexagonal.server.transaction.application.service.model.requests.AccountCreateRequest;

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
