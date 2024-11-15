package com.hexagonal.architecture.server.infra.persistence.converters.valueobjects;

import com.hexagonal.architecture.server.core.domain.valueobjects.Name;
import jakarta.persistence.AttributeConverter;

public class NameAttributeConverter implements AttributeConverter<Name, String> {

    @Override
    public String convertToDatabaseColumn(Name name) {
        return name.getFullName();
    }

    @Override
    public Name convertToEntityAttribute(String s) {
        return null;
    }

}
