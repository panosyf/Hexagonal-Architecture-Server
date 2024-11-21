package com.hexagonal.server.infra.persistence.converters.valueobjects;

import com.hexagonal.server.shared.kernel.valueobjects.Id;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
// TODO MOVE TO SHARED KERNEL
// TODO CHANGE STRING ID TO ID VALUE OBJECT IN DAOS
@Converter
public class IdAttributeConverter implements AttributeConverter<Id, String> {

    @Override
    public String convertToDatabaseColumn(Id id) {
        return id.getValue();
    }

    @Override
    public Id convertToEntityAttribute(String s) {
        return Id.valueOf(s);
    }

}