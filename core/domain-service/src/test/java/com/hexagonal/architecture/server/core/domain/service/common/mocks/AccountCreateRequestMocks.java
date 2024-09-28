package com.hexagonal.architecture.server.core.domain.service.common.mocks;

import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.common.constants.Names;

public class AccountCreateRequestMocks {

    private AccountCreateRequestMocks() {
    }

    public static AccountCreateRequest generateAccountCreateRequest() {
        return new AccountCreateRequest(Names.ACCOUNT_NAME_1);
    }

}
