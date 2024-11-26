package com.hexagonal.server.account.application.service.beans.services.transaction;

import com.hexagonal.server.account.core.domain.service.driven.TransactionRepositoryPort;
import com.hexagonal.server.account.core.domain.service.services.transaction.TransactionService;
import com.hexagonal.server.account.core.domain.service.services.transaction.TransactionServiceImpl;
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
    public TransactionService transactionService() {
        return new TransactionServiceImpl(transactionRepositoryPort);
    }

}
