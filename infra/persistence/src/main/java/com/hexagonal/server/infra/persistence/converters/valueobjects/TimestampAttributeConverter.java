package com.hexagonal.server.infra.persistence.converters.valueobjects;

import com.hexagonal.server.shared.kernel.valueobjects.Timestamp;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Instant;
// TODO MOVE TO SHARED KERNEL
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