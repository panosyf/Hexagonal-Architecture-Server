package com.hexagonal.server.infra.persistence.converters.valueobjects;

import com.hexagonal.server.shared.kernel.valueobjects.Username;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
// TODO MOVE TO SHARED KERNEL
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
