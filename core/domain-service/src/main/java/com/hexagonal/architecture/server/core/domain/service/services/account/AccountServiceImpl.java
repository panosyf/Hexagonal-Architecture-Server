package com.hexagonal.architecture.server.core.domain.service.services.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.service.logging.LogInfoMessages;
import com.hexagonal.architecture.server.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountServiceImpl implements AccountService {

    private final AccountRepositoryPort accountRepositoryPort;

    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    public AccountServiceImpl(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Account getAccount(Id id) {
        log.info("AccountServiceImpl");
        return accountRepositoryPort.findById(id);
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
    public Account increaseBalance(Id id, Money amount) {
        Account account = accountRepositoryPort.findById(id);
        account.increaseBalance(amount);
        Account updatedAccount = accountRepositoryPort.updateBalance(account);
        log.info(LogInfoMessages.LOG_BALANCE_INCREASED_FOR_ACCOUNT, id);
        return updatedAccount;
    }

    @Override
    public Account decreaseBalance(Id id, Money amount) {
        Account account = accountRepositoryPort.findById(id);
        account.decreaseBalance(amount);
        Account updatedAccount = accountRepositoryPort.updateBalance(account);
        log.info(LogInfoMessages.LOG_BALANCE_DECREASED_FOR_ACCOUNT, id);
        return updatedAccount;
    }

}
