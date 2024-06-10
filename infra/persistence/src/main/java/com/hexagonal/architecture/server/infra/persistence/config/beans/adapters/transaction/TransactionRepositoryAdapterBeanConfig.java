package com.hexagonal.architecture.server.infra.persistence.config.beans.adapters.transaction;

import com.hexagonal.architecture.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import com.hexagonal.architecture.server.infra.persistence.adapters.transaction.TransactionJpaRepository;
import com.hexagonal.architecture.server.infra.persistence.adapters.transaction.TransactionRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class TransactionRepositoryAdapterBeanConfig {

    private final TransactionJpaRepository transactionJpaRepository;
    private final ConversionService conversionService;

    public TransactionRepositoryAdapterBeanConfig(
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
