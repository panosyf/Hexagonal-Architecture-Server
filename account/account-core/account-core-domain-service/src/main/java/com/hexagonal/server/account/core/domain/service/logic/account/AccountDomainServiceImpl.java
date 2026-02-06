package com.hexagonal.server.account.core.domain.service.logic.account;

import com.hexagonal.server.account.core.domain.entities.account.Account;
import com.hexagonal.server.account.core.domain.service.logging.account.LogInfoMessages;
import com.hexagonal.server.account.core.domain.service.model.commands.account.CreateAccountCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.account.DecreaseBalanceCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.account.GetAccountCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.account.IncreaseBalanceCommand;
import com.hexagonal.server.account.core.domain.service.ports.driven.account.AccountRepositoryPort;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountDomainServiceImpl implements AccountDomainService {

    private final AccountRepositoryPort accountRepositoryPort;

    private final Logger log = LoggerFactory.getLogger(AccountDomainServiceImpl.class);

    public AccountDomainServiceImpl(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Account getAccount(final GetAccountCommand getAccountCommand) {
        log.info("AccountDomainServiceImpl");
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
