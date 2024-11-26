package com.hexagonal.server.transaction.core.domain.service.services.account;

import com.hexagonal.server.transaction.core.domain.domains.account.Account;
import com.hexagonal.server.transaction.core.domain.service.commands.CreateAccountCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.DecreaseBalanceCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.GetAccountCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.IncreaseBalanceCommand;

public interface AccountService {

    Account getAccount(GetAccountCommand getAccountCommand);

    Account createAccount(CreateAccountCommand createAccountCommand);

    Account increaseBalance(IncreaseBalanceCommand increaseBalanceCommand);

    Account decreaseBalance(DecreaseBalanceCommand decreaseBalanceCommand);

}
