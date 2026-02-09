package com.hexagonal.server.infra.persistence.adapters.account;

import com.hexagonal.server.account.core.domain.entities.account.Account;
import com.hexagonal.server.account.core.domain.exceptions.elementnotfound.account.AccountNotFoundException;
import com.hexagonal.server.account.core.domain.service.ports.driven.account.AccountRepositoryPort;
import com.hexagonal.server.infra.persistence.daos.account.AccountDao;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import jakarta.transaction.Transactional;
import org.springframework.core.convert.ConversionService;

public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final AccountJpaRepository accountJpaRepository;
    private final ConversionService conversionService;

    public AccountRepositoryAdapter(AccountJpaRepository accountRepositoryPort, ConversionService conversionService) {
        this.accountJpaRepository = accountRepositoryPort;
        this.conversionService = conversionService;
    }

    @Override
    public Account save(Account account) {
        AccountDao accountDao = conversionService.convert(account, AccountDao.class);
        AccountDao persistedAccountDao = accountJpaRepository.save(accountDao);
        return accountToDomain(persistedAccountDao);
    }

    @Override
    public Account findById(Id id) {
        AccountDao accountDao = accountJpaRepository.findById(id.getValue())
                .orElseThrow(() -> new AccountNotFoundException(id.getValue()));
        return accountToDomain(accountDao);
    }

    @Override
    public Money findBalance(Id id) {
        return Money.of(accountJpaRepository.findBalance(id.getValue()));
    }

    @Override
    @Transactional
    public Account updateBalance(Account account) {
        accountJpaRepository.updateBalance(account.getId().getValue(), account.getBalance().getValue());
        return findById(account.getId());
    }

    @Override
    public int findTotalEntries() {
        return accountJpaRepository.findTotalEntries();
    }

    @Override
    public void deleteAll() {
        accountJpaRepository.deleteAll();
    }

    private Account accountToDomain(AccountDao accountDao) {
        return conversionService.convert(accountDao, Account.class);
    }

}
