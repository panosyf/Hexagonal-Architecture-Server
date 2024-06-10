package com.hexagonal.architecture.server.api.config.beans.services.account;

import com.hexagonal.architecture.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountServiceBeanConfig {

    private final AccountRepositoryPort accountRepositoryPort;

    public AccountServiceBeanConfig(
            AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl(accountRepositoryPort);
    }

}
