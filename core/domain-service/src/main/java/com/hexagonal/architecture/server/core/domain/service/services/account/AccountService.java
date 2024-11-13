package com.hexagonal.architecture.server.core.domain.service.services.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

public interface AccountService {

    Account getAccount(Id id);

    Account createAccount(Account account);

    Account increaseBalance(Id id, Money amount);

    Account decreaseBalance(Id id, Money amount);

}
