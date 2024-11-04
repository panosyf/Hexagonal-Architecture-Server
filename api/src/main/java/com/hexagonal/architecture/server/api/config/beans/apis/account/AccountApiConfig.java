package com.hexagonal.architecture.server.api.config.beans.apis.account;

import com.hexagonal.architecture.server.api.apis.account.AccountApi;
import com.hexagonal.architecture.server.api.apis.account.AccountApiImpl;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
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
