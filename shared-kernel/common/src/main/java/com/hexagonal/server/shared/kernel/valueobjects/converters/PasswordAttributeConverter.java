package com.hexagonal.server.shared.kernel.valueobjects.converters;

import com.hexagonal.server.shared.kernel.valueobjects.Password;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PasswordAttributeConverter implements AttributeConverter<Password, String> {

    @Override
    public String convertToDatabaseColumn(Password password) {
        return password.getValue();
    }

    @Override
    public Password convertToEntityAttribute(String password) {
        return Password.valueOf(password);
    }

}
