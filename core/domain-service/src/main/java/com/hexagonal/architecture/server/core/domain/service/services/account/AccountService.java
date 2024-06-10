package com.hexagonal.architecture.server.core.domain.service.services.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;

import java.math.BigDecimal;

public interface AccountService {

    Account getAccount(String id);

    Account createAccount(AccountCreateRequest accountCreateRequest);

    void increaseBalance(String id, BigDecimal amount);

    void decreaseBalance(String id, BigDecimal amount);

}
