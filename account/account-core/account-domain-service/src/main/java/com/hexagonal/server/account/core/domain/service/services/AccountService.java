package com.hexagonal.server.account.core.domain.service.services;

import com.hexagonal.server.account.core.domain.domains.Account;
import com.hexagonal.server.account.core.domain.service.commands.CreateAccountCommand;
import com.hexagonal.server.account.core.domain.service.commands.DecreaseBalanceCommand;
import com.hexagonal.server.account.core.domain.service.commands.GetAccountCommand;
import com.hexagonal.server.account.core.domain.service.commands.IncreaseBalanceCommand;

public interface AccountService {

    Account getAccount(GetAccountCommand getAccountCommand);

    Account createAccount(CreateAccountCommand createAccountCommand);

    Account increaseBalance(IncreaseBalanceCommand increaseBalanceCommand);

    Account decreaseBalance(DecreaseBalanceCommand decreaseBalanceCommand);

}
