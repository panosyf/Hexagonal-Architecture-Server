package com.hexagonal.server.infra.persistence.converters.transaction.config;

import com.hexagonal.server.infra.persistence.converters.transaction.TransactionToDomain;
import com.hexagonal.server.infra.persistence.converters.transaction.TransactionToEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionPersistenceConvertersConfig {

    @Bean
    public TransactionToDomain transactionToDomain() {
        return new TransactionToDomain();
    }

    @Bean
    public TransactionToEntity transactionToEntity() {
        return new TransactionToEntity();
    }

}
