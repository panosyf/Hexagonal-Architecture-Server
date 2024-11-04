package com.hexagonal.architecture.server.core.domain.valueobjects;

import java.util.Objects;

public class Username extends ValueObject {

    private String value;

    public Username(String value) {
        this.value = value;
    }

    public static Username create(String value) {
        return new Username(value);
    }

    public String getValue() {
        return value;
    }

    public void update(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Username username = (Username) o;
        return Objects.equals(value, username.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Username{" +
                "value='" + value + '\'' +
                '}';
    }

}
