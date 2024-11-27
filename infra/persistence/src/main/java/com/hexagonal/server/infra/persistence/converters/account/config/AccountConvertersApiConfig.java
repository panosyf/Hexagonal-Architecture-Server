package com.hexagonal.server.infra.persistence.converters.account.config;

import com.hexagonal.server.infra.persistence.converters.account.AccountToDomain;
import com.hexagonal.server.infra.persistence.converters.account.AccountToEntity;
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
