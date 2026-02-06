package com.hexagonal.server.account.application.service.common.mocks.account;

import com.hexagonal.server.account.application.service.common.constants.account.Emails;
import com.hexagonal.server.account.application.service.common.constants.account.Names;
import com.hexagonal.server.account.application.service.common.constants.account.Passwords;
import com.hexagonal.server.account.application.service.common.constants.account.Usernames;
import com.hexagonal.server.account.application.service.model.requests.account.AccountCreateRequest;


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
