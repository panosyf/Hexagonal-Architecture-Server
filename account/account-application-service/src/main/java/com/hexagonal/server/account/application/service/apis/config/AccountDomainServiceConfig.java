package com.hexagonal.server.account.application.service.apis.config;

import com.hexagonal.server.account.core.domain.service.driven.AccountRepositoryPort;
import com.hexagonal.server.account.core.domain.service.logic.AccountDomainService;
import com.hexagonal.server.account.core.domain.service.logic.AccountDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountDomainServiceConfig {

    private final AccountRepositoryPort accountRepositoryPort;

    public AccountDomainServiceConfig(
            AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Bean
    public AccountDomainService accountService() {
        return new AccountDomainServiceImpl(accountRepositoryPort);
    }

}
