package com.hexagonal.server.transaction.application.service.beans.converters.account;

import com.hexagonal.server.transaction.application.service.converters.in.AccountCreateRequestToCommand;
import com.hexagonal.server.transaction.application.service.converters.out.AccountToDto;
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
