package com.hexagonal.architecture.server.core.domain.valueobjects;

import java.util.Objects;
import java.util.UUID;

public class Id extends ValueObject {

    private final String value;

    private Id(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("Id cannot be null");
        this.value = value;
    }

    public static Id generate() {
        return new Id(UUID.randomUUID().toString());
    }

    public static Id generate(UUID uuid) {
        return new Id(uuid.toString());
    }

    public static Id generate(String value) {
        return new Id(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return Objects.equals(value, id.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Id{" +
                "value='" + value + '\'' +
                '}';
    }

}
