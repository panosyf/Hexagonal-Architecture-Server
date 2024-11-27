package com.hexagonal.server.transaction.application.service.apis.config;

import com.hexagonal.server.transaction.application.service.apis.AccountApi;
import com.hexagonal.server.transaction.application.service.apis.TransactionApi;
import com.hexagonal.server.transaction.application.service.apis.TransactionApiImpl;
import com.hexagonal.server.transaction.core.domain.service.services.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class TransactionApiConfig {

    private final TransactionService transactionService;
    private final AccountApi accountApi;
    private final ConversionService conversionService;

    public TransactionApiConfig(TransactionService transactionService, AccountApi accountApi, ConversionService conversionService) {
        this.transactionService = transactionService;
        this.accountApi = accountApi;
        this.conversionService = conversionService;
    }

    @Bean
    public TransactionApi transactionApi() {
        return new TransactionApiImpl(transactionService, accountApi, conversionService);
    }

}
