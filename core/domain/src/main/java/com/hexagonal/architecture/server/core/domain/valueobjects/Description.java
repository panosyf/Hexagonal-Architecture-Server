package com.hexagonal.architecture.server.core.domain.valueobjects;

import java.util.Objects;

public class Description extends ValueObject {

    private final String value;
    private static final String EMPTY_DESCRIPTION = "";

    private Description(final String value) {
        this.value = value;
    }

    public static Description valueOf(final String value) {
        return new Description(value == null || value.isBlank() ? EMPTY_DESCRIPTION : value);
    }

    public static Description emptyDescription() {
        return new Description(EMPTY_DESCRIPTION);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Description{" +
                "value='" + value + '\'' +
                '}';
    }

}
