package com.hexagonal.architecture.server.api.config.beans.facades.account;

import com.hexagonal.architecture.server.api.facades.account.AccountFacade;
import com.hexagonal.architecture.server.api.facades.account.AccountFacadeImpl;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class AccountFacadeBeanConfig {

    private final AccountService accountService;
    private final ConversionService conversionService;

    public AccountFacadeBeanConfig(AccountService accountService, ConversionService conversionService) {
        this.accountService = accountService;
        this.conversionService = conversionService;
    }

    @Bean
    public AccountFacade accountFacade() {
        return new AccountFacadeImpl(accountService, conversionService);
    }

}
