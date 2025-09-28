package com.hexagonal.server.application.service.logic.config.account;

import com.hexagonal.server.core.domain.service.logic.account.AccountDomainServiceImpl;
import com.hexagonal.server.core.domain.service.ports.driven.account.AccountRepositoryPort;
import com.hexagonal.server.core.domain.service.logic.account.AccountDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountServiceConfig {

    private final AccountRepositoryPort accountRepositoryPort;

    public AccountServiceConfig(
            AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Bean
    public AccountDomainService accountService() {
        return new AccountDomainServiceImpl(accountRepositoryPort);
    }

}
