package com.hexagonal.server.transaction.application.service.apis.config;

import com.hexagonal.server.transaction.application.service.apis.AccountApi;
import com.hexagonal.server.transaction.application.service.apis.TransactionApi;
import com.hexagonal.server.transaction.application.service.apis.TransactionApiImpl;
import com.hexagonal.server.transaction.core.domain.service.logic.TransactionDomainService;
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
