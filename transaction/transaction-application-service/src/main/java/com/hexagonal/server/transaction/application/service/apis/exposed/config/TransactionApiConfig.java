package com.hexagonal.server.transaction.application.service.apis.exposed.config;

import com.hexagonal.server.transaction.application.service.apis.exposed.TransactionApi;
import com.hexagonal.server.transaction.application.service.apis.exposed.TransactionApiImpl;
import com.hexagonal.server.transaction.application.service.apis.external.AccountExternalApi;
import com.hexagonal.server.transaction.core.domain.service.logic.TransactionDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class TransactionApiConfig {

    private final TransactionDomainService transactionDomainService;
    private final AccountExternalApi accountExternalApi;
    private final ConversionService conversionService;

    public TransactionApiConfig(TransactionDomainService transactionDomainService, AccountExternalApi accountExternalApi, ConversionService conversionService) {
        this.transactionDomainService = transactionDomainService;
        this.accountExternalApi = accountExternalApi;
        this.conversionService = conversionService;
    }

    @Bean
    public TransactionApi transactionApi() {
        return new TransactionApiImpl(transactionDomainService, accountExternalApi, conversionService);
    }

}
