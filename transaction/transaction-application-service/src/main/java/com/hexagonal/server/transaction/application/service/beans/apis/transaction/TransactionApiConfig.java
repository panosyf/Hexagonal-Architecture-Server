package com.hexagonal.server.transaction.application.service.beans.apis.transaction;

import com.hexagonal.server.transaction.core.domain.service.services.TransactionService;
import com.hexagonal.server.transaction.application.service.apis.account.AccountApi;
import com.hexagonal.server.transaction.application.service.apis.transaction.TransactionApi;
import com.hexagonal.server.transaction.application.service.apis.transaction.TransactionApiImpl;
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
