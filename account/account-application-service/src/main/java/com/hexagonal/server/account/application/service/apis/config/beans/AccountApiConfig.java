package com.hexagonal.server.account.application.service.apis.config.beans;

import com.hexagonal.server.account.application.service.apis.AccountApi;
import com.hexagonal.server.account.application.service.apis.AccountApiImpl;
import com.hexagonal.server.account.core.domain.service.services.AccountService;
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
