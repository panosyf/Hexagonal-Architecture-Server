package com.hexagonal.architecture.server.core.domain.service.services.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.service.logging.LogInfoMessages;
import com.hexagonal.architecture.server.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.architecture.server.core.domain.service.model.commands.DecreaseBalanceCommand;
import com.hexagonal.architecture.server.core.domain.service.model.commands.GetAccountCommand;
import com.hexagonal.architecture.server.core.domain.service.model.commands.IncreaseBalanceCommand;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountServiceImpl implements AccountService {

    private final AccountRepositoryPort accountRepositoryPort;

    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    public AccountServiceImpl(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Account getAccount(final GetAccountCommand getAccountCommand) {
        log.info("AccountServiceImpl");
        return accountRepositoryPort.findById(getAccountCommand.id());
    }

    @Override
    public Account createAccount(final CreateAccountCommand createAccountCommand) {
        Account account = new Account(
                createAccountCommand.email(),
                createAccountCommand.username(),
                createAccountCommand.password(),
                createAccountCommand.name()
        );
        Account persistedAccount = accountRepositoryPort.save(account);
        log.info(LogInfoMessages.LOG_ACCOUNT_CREATED_INFO, persistedAccount.getEmail(), persistedAccount.getUsername());
        return persistedAccount;
    }

    @Override
    public Account increaseBalance(final IncreaseBalanceCommand increaseBalanceCommand) {
        Id id = increaseBalanceCommand.id();
        Account account = accountRepositoryPort.findById(id);
        account.increaseBalance(increaseBalanceCommand.amount());
        Account updatedAccount = accountRepositoryPort.updateBalance(account);
        log.info(LogInfoMessages.LOG_BALANCE_INCREASED_FOR_ACCOUNT, id);
        return updatedAccount;
    }

    @Override
    public Account decreaseBalance(final DecreaseBalanceCommand decreaseBalanceCommand) {
        Id id = decreaseBalanceCommand.id();
        Account account = accountRepositoryPort.findById(id);
        account.decreaseBalance(decreaseBalanceCommand.amount());
        Account updatedAccount = accountRepositoryPort.updateBalance(account);
        log.info(LogInfoMessages.LOG_BALANCE_DECREASED_FOR_ACCOUNT, id);
        return updatedAccount;
    }

}
