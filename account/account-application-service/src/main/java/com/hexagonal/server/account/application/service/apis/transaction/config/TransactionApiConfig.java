package com.hexagonal.server.account.application.service.apis.transaction.config;

import com.hexagonal.server.account.application.service.apis.account.AccountApi;
import com.hexagonal.server.account.application.service.apis.transaction.TransactionApi;
import com.hexagonal.server.account.application.service.apis.transaction.TransactionApiImpl;
import com.hexagonal.server.account.core.domain.service.logic.transaction.TransactionDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class TransactionApiConfig {

    private final TransactionDomainService transactionDomainService;
    private final AccountApi accountApi;
    private final ConversionService conversionService;

    public TransactionApiConfig(TransactionDomainService transactionDomainService, AccountApi accountApi, ConversionService conversionService) {
        this.transactionDomainService = transactionDomainService;
        this.accountApi = accountApi;
        this.conversionService = conversionService;
    }

    @Bean
    public TransactionApi transactionApi() {
        return new TransactionApiImpl(transactionDomainService, accountApi, conversionService);
    }

}
