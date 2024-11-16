package com.hexagonal.architecture.server.infra.persistence.converters.valueobjects;

import com.hexagonal.architecture.server.core.domain.valueobjects.Username;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UsernameAttributeConverter implements AttributeConverter<Username, String> {

    @Override
    public String convertToDatabaseColumn(Username username) {
        return username.getValue();
    }

    @Override
    public Username convertToEntityAttribute(String username) {
        return Username.valueOf(username);
    }

}
