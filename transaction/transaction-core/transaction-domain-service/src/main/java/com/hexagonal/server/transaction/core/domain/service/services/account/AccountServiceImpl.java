package com.hexagonal.server.transaction.core.domain.service.services.account;

import com.hexagonal.server.transaction.core.domain.domains.account.Account;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.transaction.core.domain.service.commands.CreateAccountCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.DecreaseBalanceCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.GetAccountCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.IncreaseBalanceCommand;
import com.hexagonal.server.transaction.core.domain.service.driven.AccountRepositoryPort;
import com.hexagonal.server.transaction.core.domain.service.logging.LogInfoMessages;
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
