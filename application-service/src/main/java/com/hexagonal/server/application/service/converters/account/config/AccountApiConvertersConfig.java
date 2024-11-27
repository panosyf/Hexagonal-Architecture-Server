package com.hexagonal.server.application.service.converters.account.config;

import com.hexagonal.server.application.service.converters.account.in.AccountCreateRequestToCommand;
import com.hexagonal.server.application.service.converters.account.out.AccountToDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountApiConvertersConfig {

    @Bean
    public AccountToDto accountToDto() {
        return new AccountToDto();
    }

    @Bean
    public AccountCreateRequestToCommand accountCreateRequestToCommand() {
        return new AccountCreateRequestToCommand();
    }

}
