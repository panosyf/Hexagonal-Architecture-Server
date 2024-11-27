package com.hexagonal.server.account.application.service.apis.exposed.config;

import com.hexagonal.server.account.application.service.apis.exposed.AccountApi;
import com.hexagonal.server.account.application.service.apis.exposed.AccountApiImpl;
import com.hexagonal.server.account.core.domain.service.logic.AccountDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class AccountApiConfig {

    private final AccountDomainService accountDomainService;
    private final ConversionService conversionService;

    public AccountApiConfig(AccountDomainService accountDomainService, ConversionService conversionService) {
        this.accountDomainService = accountDomainService;
        this.conversionService = conversionService;
    }

    @Bean
    public AccountApi accountApi() {
        return new AccountApiImpl(accountDomainService, conversionService);
    }

}
