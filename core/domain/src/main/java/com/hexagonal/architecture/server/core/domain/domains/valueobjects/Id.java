package com.hexagonal.architecture.server.core.domain.domains.valueobjects;

import java.util.Objects;
import java.util.UUID;

public class Id {

    private final String value;

    private Id(String uuid) {
        this.value = uuid;
    }

    public static Id generate() {
        return new Id(UUID.randomUUID().toString());
    }

    public static Id generate(UUID uuid) {
        return new Id(uuid.toString());
    }

    public static Id generate(String uuid) {
        return new Id(uuid);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Id{" +
                "value='" + value + '\'' +
                '}';
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
}
