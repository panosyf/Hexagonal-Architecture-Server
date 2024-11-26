package com.hexagonal.server.account.infra.persistence.converters.config.beans;

import com.hexagonal.server.account.infra.persistence.converters.AccountToDomain;
import com.hexagonal.server.account.infra.persistence.converters.AccountToEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConvertersApiConfig {

    @Bean
    public AccountToDomain accountToDomain() {
        return new AccountToDomain();
    }

    @Bean
    public AccountToEntity accountToEntity() {
        return new AccountToEntity();
    }

}
