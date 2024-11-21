package com.hexagonal.server.infra.persistence.converters.valueobjects;

import com.hexagonal.server.shared.kernel.valueobjects.Money;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;
// TODO MOVE TO SHARED KERNEL
@Converter
public class MoneyAttributeConverter implements AttributeConverter<Money, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(Money money) {
        return money.getValue();
    }

    @Override
    public Money convertToEntityAttribute(BigDecimal bigDecimal) {
        return Money.of(bigDecimal);
    }

}