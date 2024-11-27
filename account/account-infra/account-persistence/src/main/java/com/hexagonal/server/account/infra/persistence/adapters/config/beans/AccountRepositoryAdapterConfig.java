package com.hexagonal.server.account.infra.persistence.adapters.config.beans;

import com.hexagonal.server.account.core.domain.service.driven.AccountRepositoryPort;
import com.hexagonal.server.account.infra.persistence.adapters.AccountJpaRepository;
import com.hexagonal.server.account.infra.persistence.adapters.AccountRepositoryAdapter;
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