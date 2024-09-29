package com.hexagonal.architecture.server.infra.persistence.adapters.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.exceptions.notfound.AccountNotFoundException;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.architecture.server.infra.persistence.entities.AccountEntity;
import jakarta.transaction.Transactional;
import org.springframework.core.convert.ConversionService;

import java.math.BigDecimal;

public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final AccountJpaRepository accountJpaRepository;
    private final ConversionService conversionService;

    public AccountRepositoryAdapter(AccountJpaRepository accountRepositoryPort, ConversionService conversionService) {
        this.accountJpaRepository = accountRepositoryPort;
        this.conversionService = conversionService;
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = conversionService.convert(account, AccountEntity.class);
        AccountEntity persistedAccountEntity = accountJpaRepository.save(accountEntity);
        return accountToDomain(persistedAccountEntity);
    }

    @Override
    public Account findById(String id) {
        AccountEntity accountEntity = accountJpaRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        return accountToDomain(accountEntity);
    }

    @Override
    public BigDecimal findBalance(String id) {
        return accountJpaRepository.findBalance(id);
    }

    @Override
    @Transactional
    public Account updateBalance(String id, BigDecimal amount) {
        accountJpaRepository.updateBalance(id, amount);
        return findById(id);
    }

    @Override
    public int findTotalEntries() {
        return accountJpaRepository.findTotalEntries();
    }

    @Override
    public void deleteAll() {
        accountJpaRepository.deleteAll();
    }

    private Account accountToDomain(AccountEntity accountEntity) {
        return conversionService.convert(accountEntity, Account.class);
    }

}
