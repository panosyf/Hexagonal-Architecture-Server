package com.hexagonal.architecture.server.api.common.mocks;

import com.hexagonal.architecture.server.api.common.constants.Emails;
import com.hexagonal.architecture.server.api.common.constants.Names;
import com.hexagonal.architecture.server.api.common.constants.Passwords;
import com.hexagonal.architecture.server.api.common.constants.Usernames;
import com.hexagonal.architecture.server.api.model.requests.AccountCreateRequest;


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
