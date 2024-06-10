package com.hexagonal.architecture.server.core.domain.service.common.mocks;

import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.common.constants.Name;

public class AccountCreateRequestMocks {

    private AccountCreateRequestMocks() {
    }

    public static AccountCreateRequest generateAccountCreateRequest() {
        return new AccountCreateRequest(Name.ACCOUNT_NAME_1);
    }

}
