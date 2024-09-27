package com.hexagonal.architecture.server.infra.common.mocks;

import com.hexagonal.architecture.server.infra.common.constants.Name;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;

public class AccountCreateRequestMocks {

    private AccountCreateRequestMocks() {
    }

    public static AccountCreateRequest generateAccountCreateRequest() {
        return new AccountCreateRequest(Name.ACCOUNT_NAME_1);
    }

}
