package com.hexagonal.architecture.server.common.mocks;

import com.hexagonal.architecture.server.common.constants.Name;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;

public class AccountCreateRequestMocks {

    private AccountCreateRequestMocks() {
    }

    public static AccountCreateRequest generateAccountCreateRequest() {
        return new AccountCreateRequest(Name.ACCOUNT_NAME_1);
    }

}
