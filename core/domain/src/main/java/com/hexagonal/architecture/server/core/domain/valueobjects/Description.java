package com.hexagonal.architecture.server.core.domain.valueobjects;

import java.util.Objects;

public class Description extends ValueObject {

    private String value;

    public Description(String value) {
        this.value = value;
    }

    public static Description valueOf(String value) {
        return new Description(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
