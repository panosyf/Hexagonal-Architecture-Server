package com.hexagonal.server.application.service.logic.config.transaction;

import com.hexagonal.server.core.domain.service.logic.transaction.TransactionDomainServiceImpl;
import com.hexagonal.server.core.domain.service.ports.driven.transaction.TransactionRepositoryPort;
import com.hexagonal.server.core.domain.service.logic.transaction.TransactionDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionServiceConfig {
    private final TransactionRepositoryPort transactionRepositoryPort;

    public TransactionServiceConfig(
            TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Bean
    public TransactionDomainService transactionService() {
        return new TransactionDomainServiceImpl(transactionRepositoryPort);
    }

}
