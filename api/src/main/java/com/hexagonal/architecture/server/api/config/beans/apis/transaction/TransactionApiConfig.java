package com.hexagonal.architecture.server.api.config.beans.apis.transaction;

import com.hexagonal.architecture.server.api.apis.account.AccountApi;
import com.hexagonal.architecture.server.api.apis.transaction.TransactionApi;
import com.hexagonal.architecture.server.api.apis.transaction.TransactionApiImpl;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionService;
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
