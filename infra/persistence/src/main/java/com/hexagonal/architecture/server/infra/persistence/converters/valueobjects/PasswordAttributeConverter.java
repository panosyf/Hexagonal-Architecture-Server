package com.hexagonal.architecture.server.infra.persistence.converters.valueobjects;

import com.hexagonal.architecture.server.shared.kernel.valueobjects.Password;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
// TODO MOVE TO SHARED KERNEL
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
