package com.hexagonal.architecture.server.infra.persistence.config.beans.adapters.account;

import com.hexagonal.architecture.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.architecture.server.infra.persistence.adapters.account.AccountJpaRepository;
import com.hexagonal.architecture.server.infra.persistence.adapters.account.AccountRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class AccountRepositoryAdapterBeanConfig {

    private final AccountJpaRepository accountJpaRepository;
    private final ConversionService conversionService;

    public AccountRepositoryAdapterBeanConfig(
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
