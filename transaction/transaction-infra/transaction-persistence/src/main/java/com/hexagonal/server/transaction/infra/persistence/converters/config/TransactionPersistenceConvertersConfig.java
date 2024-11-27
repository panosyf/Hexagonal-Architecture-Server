package com.hexagonal.server.transaction.infra.persistence.converters.config;

import com.hexagonal.server.transaction.infra.persistence.converters.TransactionToDomain;
import com.hexagonal.server.transaction.infra.persistence.converters.TransactionToEntity;
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
