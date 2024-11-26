package com.hexagonal.server.transaction.infra.persistence.beans.adapters.account;

import com.hexagonal.server.transaction.core.domain.service.driven.AccountRepositoryPort;
import com.hexagonal.server.transaction.infra.persistence.adapters.account.AccountJpaRepository;
import com.hexagonal.server.transaction.infra.persistence.adapters.account.AccountRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class AccountRepositoryAdapterConfig {

    private final AccountJpaRepository accountJpaRepository;
    private final ConversionService conversionService;

    public AccountRepositoryAdapterConfig(
            AccountJpaRepository accountJpaRepository,
            ConversionService conversionService) {
        this.accountJpaRepository = accountJpaRepository;
        this.conversionService = conversionService;
    }

    @Bean
    public AccountRepositoryPort accountRepositoryPort() {
        return new AccountRepositoryAdapter(accountJpaRepository, conversionService);
    }

}
