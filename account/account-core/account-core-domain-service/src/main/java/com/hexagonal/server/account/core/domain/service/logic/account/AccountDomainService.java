package com.hexagonal.server.account.core.domain.service.logic.account;

import com.hexagonal.server.account.core.domain.entities.account.Account;
import com.hexagonal.server.account.core.domain.service.model.commands.account.CreateAccountCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.account.DecreaseBalanceCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.account.GetAccountCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.account.IncreaseBalanceCommand;

public interface AccountDomainService {

    Account getAccount(GetAccountCommand getAccountCommand);

    Account createAccount(CreateAccountCommand createAccountCommand);

    Account increaseBalance(IncreaseBalanceCommand increaseBalanceCommand);

    Account decreaseBalance(DecreaseBalanceCommand decreaseBalanceCommand);

}
