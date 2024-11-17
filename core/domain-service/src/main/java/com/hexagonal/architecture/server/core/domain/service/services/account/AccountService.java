package com.hexagonal.architecture.server.core.domain.service.services.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

public interface AccountService {

    // TODO USE COMMAND AS INPUT
    Account getAccount(Id id);

    Account createAccount(CreateAccountCommand createAccountCommand);

    // TODO USE COMMAND AS INPUT
    Account increaseBalance(Id id, Money amount);

    // TODO USE COMMAND AS INPUT
    Account decreaseBalance(Id id, Money amount);

}
