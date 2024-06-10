package com.hexagonal.architecture.server.api.common.mocks;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.api.common.constants.Name;
import com.hexagonal.architecture.server.core.domain.model.constants.Balance;

import java.math.BigDecimal;

public class AccountMocks {

    private AccountMocks() {
    }

    public static Account generateAccount() {
        return new Account(Name.ACCOUNT_NAME_1, Balance.BALANCE_0);
    }

    public static Account generateAccount(BigDecimal balance) {
        return new Account(Name.ACCOUNT_NAME_1, balance);
    }

}
