package com.hexagonal.server.transaction.application.service.apis.config;

import com.hexagonal.server.transaction.core.domain.service.driven.TransactionRepositoryPort;
import com.hexagonal.server.transaction.core.domain.service.logic.TransactionDomainService;
import com.hexagonal.server.transaction.core.domain.service.logic.TransactionDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionDomainServiceConfig {
    private final TransactionRepositoryPort transactionRepositoryPort;

    public TransactionDomainServiceConfig(
            TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Bean
    public TransactionDomainService transactionService() {
        return new TransactionDomainServiceImpl(transactionRepositoryPort);
    }

}
