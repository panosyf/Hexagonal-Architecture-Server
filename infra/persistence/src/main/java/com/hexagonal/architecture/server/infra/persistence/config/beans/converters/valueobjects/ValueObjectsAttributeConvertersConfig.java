package com.hexagonal.architecture.server.infra.persistence.config.beans.converters.valueobjects;

import com.hexagonal.architecture.server.infra.persistence.converters.valueobjects.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValueObjectsAttributeConvertersConfig {

    @Bean
    public DescriptionAttributeConverter descriptionAttributeConverter() {
        return new DescriptionAttributeConverter();
    }

    @Bean
    public EmailAttributeConverter emailAttributeConverter() {
        return new EmailAttributeConverter();
    }

    @Bean
    public IdAttributeConverter idAttributeConverter() {
        return new IdAttributeConverter();
    }

    @Bean
    public MoneyAttributeConverter moneyAttributeConverter() {
        return new MoneyAttributeConverter();
    }

    @Bean
    public NameAttributeConverter nameAttributeConverter() {
        return new NameAttributeConverter();
    }

    @Bean
    public PasswordAttributeConverter passwordAttributeConverter() {
        return new PasswordAttributeConverter();
    }

    @Bean
    public TimestampAttributeConverter timestampAttributeConverter() {
        return new TimestampAttributeConverter();
    }

    @Bean
    public UsernameAttributeConverter usernameAttributeConverter() {
        return new UsernameAttributeConverter();
    }

}
