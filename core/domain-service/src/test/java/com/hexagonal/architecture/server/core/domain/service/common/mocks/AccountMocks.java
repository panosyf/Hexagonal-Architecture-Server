package com.hexagonal.architecture.server.core.domain.service.common.mocks;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.model.constants.Balance;
import com.hexagonal.architecture.server.core.domain.service.common.constants.Names;

import java.math.BigDecimal;

public class AccountMocks {

    private AccountMocks() {
    }

    public static Account generateAccount() {
        return new Account(Names.ACCOUNT_NAME_1, Balance.BALANCE_0);
    }

    public static Account generateAccount(BigDecimal balance) {
        return new Account(Names.ACCOUNT_NAME_1, balance);
    }

}
