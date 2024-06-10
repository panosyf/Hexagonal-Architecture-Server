package com.hexagonal.architecture.server.api.config.beans.services.transaction;

import com.hexagonal.architecture.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionService;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionServiceBeanConfig {
    private final TransactionRepositoryPort transactionRepositoryPort;

    public TransactionServiceBeanConfig(
            TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Bean
    public TransactionService transactionService() {
        return new TransactionServiceImpl(transactionRepositoryPort);
    }

}
