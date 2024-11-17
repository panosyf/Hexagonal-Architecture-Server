package com.hexagonal.architecture.server.api.config.beans.converters.transaction;

import com.hexagonal.architecture.server.api.converters.in.TransactionCreateRequestToCommand;
import com.hexagonal.architecture.server.api.converters.out.TransactionToDto;
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
