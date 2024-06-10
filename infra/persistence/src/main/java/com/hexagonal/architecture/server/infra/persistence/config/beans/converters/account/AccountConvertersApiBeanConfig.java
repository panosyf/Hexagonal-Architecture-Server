package com.hexagonal.architecture.server.infra.persistence.config.beans.converters.account;

import com.hexagonal.architecture.server.infra.persistence.converters.account.AccountToDomain;
import com.hexagonal.architecture.server.infra.persistence.converters.account.AccountToEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConvertersApiBeanConfig {

    @Bean
    public AccountToDomain accountToDomain() {
        return new AccountToDomain();
    }

    @Bean
    public AccountToEntity accountToEntity() {
        return new AccountToEntity();
    }

}
