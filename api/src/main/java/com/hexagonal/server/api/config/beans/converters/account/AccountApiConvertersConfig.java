package com.hexagonal.server.api.config.beans.converters.account;

import com.hexagonal.server.api.converters.in.AccountCreateRequestToCommand;
import com.hexagonal.server.api.converters.out.AccountToDto;
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
