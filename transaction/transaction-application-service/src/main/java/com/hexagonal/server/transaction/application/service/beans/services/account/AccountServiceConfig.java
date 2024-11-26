package com.hexagonal.server.transaction.application.service.beans.services.account;

import com.hexagonal.server.transaction.core.domain.service.driven.AccountRepositoryPort;
import com.hexagonal.server.transaction.core.domain.service.services.account.AccountService;
import com.hexagonal.server.transaction.core.domain.service.services.account.AccountServiceImpl;
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
