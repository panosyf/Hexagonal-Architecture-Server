package com.hexagonal.server.infra.persistence.converters.valueobjects;

import com.hexagonal.server.shared.kernel.valueobjects.Email;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
// TODO MOVE TO SHARED KERNEL
@Converter
public class EmailAttributeConverter implements AttributeConverter<Email, String> {

    @Override
    public String convertToDatabaseColumn(Email email) {
        return email.getValue();
    }

    @Override
    public Email convertToEntityAttribute(String s) {
        return Email.valueOf(s);
    }

}
