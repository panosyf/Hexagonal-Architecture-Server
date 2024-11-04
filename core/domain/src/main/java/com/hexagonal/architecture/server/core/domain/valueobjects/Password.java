package com.hexagonal.architecture.server.core.domain.valueobjects;

import java.util.Objects;

public class Password extends ValueObject {

    private final String value;

    private Password(String value) {
        this.value = value;
    }

    public static Password valueOf(String value) {
        return new Password(value);
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Objects.equals(value, password.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Password{" +
                "value='" + value + '\'' +
                '}';
    }

}
