package com.hexagonal.server.infra.persistence.adapter.out.account;

import com.hexagonal.server.account.core.domain.account.Account;
import com.hexagonal.server.account.core.exception.elementnotfound.account.AccountNotFoundException;
import com.hexagonal.server.account.core.port.out.account.AccountRepositoryPort;
import com.hexagonal.server.infra.persistence.entity.account.AccountEntity;
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
        AccountEntity accountEntity = conversionService.convert(account, AccountEntity.class);
        AccountEntity persistedAccountEntity = accountJpaRepository.save(accountEntity);
        return accountToDomain(persistedAccountEntity);
    }

    @Override
    public Account findById(Id id) {
        AccountEntity accountEntity = accountJpaRepository.findById(id.getValue())
                .orElseThrow(() -> new AccountNotFoundException(id.getValue()));
        return accountToDomain(accountEntity);
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

    private Account accountToDomain(AccountEntity accountEntity) {
        return conversionService.convert(accountEntity, Account.class);
    }

}
