package com.hexagonal.server.account.application.converters.transaction.config;

import com.hexagonal.server.account.application.converters.transaction.in.TransactionCreateRequestToCommand;
import com.hexagonal.server.account.application.converters.transaction.out.TransactionToDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionApiConvertersConfig {

    @Bean
    public TransactionToDto transactionToDto() {
        return new TransactionToDto();
    }

    @Bean
    public TransactionCreateRequestToCommand transactionCreateRequestToCommand() {
        return new TransactionCreateRequestToCommand();
    }

}
