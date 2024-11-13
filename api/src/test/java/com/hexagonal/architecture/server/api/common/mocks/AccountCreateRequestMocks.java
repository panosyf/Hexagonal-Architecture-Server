package com.hexagonal.architecture.server.api.common.mocks;

import com.hexagonal.architecture.server.api.common.constants.Names;
import com.hexagonal.architecture.server.api.model.requests.AccountCreateRequest;


public class AccountCreateRequestMocks {

    private AccountCreateRequestMocks() {
    }

    public static AccountCreateRequest generateAccountCreateRequest() {
        return new AccountCreateRequest(Names.ACCOUNT_NAME_1);
    }

}
