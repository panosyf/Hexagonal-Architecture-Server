package com.hexagonal.server.account.application.service.services.beans.config;

import com.hexagonal.server.account.core.domain.service.driven.AccountRepositoryPort;
import com.hexagonal.server.account.core.domain.service.services.AccountService;
import com.hexagonal.server.account.core.domain.service.services.AccountServiceImpl;
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
    public AccountService accountService() {
        return new AccountServiceImpl(accountRepositoryPort);
    }

}
