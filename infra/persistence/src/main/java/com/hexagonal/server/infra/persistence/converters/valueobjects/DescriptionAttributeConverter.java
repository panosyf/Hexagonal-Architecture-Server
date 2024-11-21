package com.hexagonal.server.infra.persistence.converters.valueobjects;

import com.hexagonal.server.shared.kernel.valueobjects.Description;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
// TODO MOVE TO SHARED KERNEL
@Converter
public class DescriptionAttributeConverter implements AttributeConverter<Description, String> {

    @Override
    public String convertToDatabaseColumn(Description description) {
        return description.getValue();
    }

    @Override
    public Description convertToEntityAttribute(String s) {
        return Description.valueOf(s);
    }

}
