package com.hexagonal.server.transaction.application.service.beans.apis.account;

import com.hexagonal.server.transaction.core.domain.service.services.account.AccountService;
import com.hexagonal.server.transaction.application.service.apis.account.AccountApi;
import com.hexagonal.server.transaction.application.service.apis.account.AccountApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class AccountApiConfig {

    private final AccountService accountService;
    private final ConversionService conversionService;

    public AccountApiConfig(AccountService accountService, ConversionService conversionService) {
        this.accountService = accountService;
        this.conversionService = conversionService;
    }

    @Bean
    public AccountApi accountApi() {
        return new AccountApiImpl(accountService, conversionService);
    }

}
