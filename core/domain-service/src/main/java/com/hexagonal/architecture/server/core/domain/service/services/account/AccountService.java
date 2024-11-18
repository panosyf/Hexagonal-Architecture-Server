package com.hexagonal.architecture.server.core.domain.service.services.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.architecture.server.core.domain.service.model.commands.DecreaseBalanceCommand;
import com.hexagonal.architecture.server.core.domain.service.model.commands.GetAccountCommand;
import com.hexagonal.architecture.server.core.domain.service.model.commands.IncreaseBalanceCommand;

public interface AccountService {

    Account getAccount(GetAccountCommand getAccountCommand);

    Account createAccount(CreateAccountCommand createAccountCommand);

    Account increaseBalance(IncreaseBalanceCommand increaseBalanceCommand);

    Account decreaseBalance(DecreaseBalanceCommand decreaseBalanceCommand);

}
