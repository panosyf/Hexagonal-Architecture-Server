package com.hexagonal.architecture.server.infra.persistence.converters.valueobjects;

import com.hexagonal.architecture.server.core.domain.valueobjects.Timestamp;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Instant;

@Converter
public class TimestampAttributeConverter implements AttributeConverter<Timestamp, Instant> {

    @Override
    public Instant convertToDatabaseColumn(Timestamp timestamp) {
        return timestamp.getTime();
    }

    @Override
    public Timestamp convertToEntityAttribute(Instant instant) {
        return Timestamp.valueOf(instant);
    }

}
