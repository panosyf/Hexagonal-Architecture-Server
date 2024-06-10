package com.hexagonal.architecture.server.api.config.beans.facades.transaction;

import com.hexagonal.architecture.server.api.facades.transaction.TransactionFacade;
import com.hexagonal.architecture.server.api.facades.transaction.TransactionFacadeImpl;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class TransactionFacadeBeanConfig {

    private final TransactionService transactionService;
    private final AccountService accountService;
    private final ConversionService conversionService;

    public TransactionFacadeBeanConfig(TransactionService transactionService, AccountService accountService, ConversionService conversionService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.conversionService = conversionService;
    }

    @Bean
    public TransactionFacade transactionFacade() {
        return new TransactionFacadeImpl(transactionService, accountService, conversionService);
    }

}
