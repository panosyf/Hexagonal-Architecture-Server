package com.hexagonal.architecture.server.core.domain.service.services.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.service.logging.LogInfoMessages;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.AccountRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {

    private final AccountRepositoryPort accountRepositoryPort;

    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    public AccountServiceImpl(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Account getAccount(String id) {
        log.info("AccountServiceImpl");
        return accountRepositoryPort.findById(id);
    }

    @Override
    public Account createAccount(AccountCreateRequest accountCreateRequest) {
        // TODO UTILIZE HASHING AND SALT
        // TODO HIDE PASSWORD FROM LOGS
        Account account = new Account(accountCreateRequest.name());
        account = accountRepositoryPort.save(account);
        log.info(LogInfoMessages.LOG_ACCOUNT_CREATED_INFO, accountCreateRequest);
        return account;
    }

    @Override
    public Account increaseBalance(String id, BigDecimal amount) {
        Account account = accountRepositoryPort.findById(id);
        account.increaseBalance(amount);
        Account updatedAccount = accountRepositoryPort.updateBalance(account);
        log.info(LogInfoMessages.LOG_BALANCE_INCREASED_FOR_ACCOUNT, id);
        return updatedAccount;
    }

    @Override
    public Account decreaseBalance(String id, BigDecimal amount) {
        Account account = accountRepositoryPort.findById(id);
        account.decreaseBalance(amount);
        Account updatedAccount = accountRepositoryPort.updateBalance(account);
        log.info(LogInfoMessages.LOG_BALANCE_DECREASED_FOR_ACCOUNT, id);
        return updatedAccount;
    }

}
