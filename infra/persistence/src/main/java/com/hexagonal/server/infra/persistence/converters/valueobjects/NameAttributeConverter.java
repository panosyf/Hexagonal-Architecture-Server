package com.hexagonal.server.infra.persistence.converters.valueobjects;

import com.hexagonal.server.shared.kernel.valueobjects.Name;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
// TODO MOVE TO SHARED KERNEL
@Converter
public class NameAttributeConverter implements AttributeConverter<Name, String> {

    @Override
    public String convertToDatabaseColumn(Name name) {
        return name.getFullName();
    }

    @Override
    public Name convertToEntityAttribute(String fullName) {
        return Name.valueOf(fullName);
    }

}
