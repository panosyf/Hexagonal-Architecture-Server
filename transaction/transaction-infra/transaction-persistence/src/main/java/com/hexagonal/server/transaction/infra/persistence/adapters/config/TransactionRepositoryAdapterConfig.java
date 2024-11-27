package com.hexagonal.server.transaction.infra.persistence.adapters.config;

import com.hexagonal.server.transaction.core.domain.service.driven.TransactionRepositoryPort;
import com.hexagonal.server.transaction.infra.persistence.adapters.TransactionJpaRepository;
import com.hexagonal.server.transaction.infra.persistence.adapters.TransactionRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class TransactionRepositoryAdapterConfig {

    private final TransactionJpaRepository transactionJpaRepository;
    private final ConversionService conversionService;

    public TransactionRepositoryAdapterConfig(
            TransactionJpaRepository transactionJpaRepository,
            ConversionService conversionService) {
        this.transactionJpaRepository = transactionJpaRepository;
        this.conversionService = conversionService;
    }

    @Bean
    public TransactionRepositoryPort transactionRepositoryPort() {
        return new TransactionRepositoryAdapter(transactionJpaRepository, conversionService);
    }

}
