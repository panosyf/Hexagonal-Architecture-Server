package com.hexagonal.architecture.server.core.domain.valueobjects;

import com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants;

import java.util.Objects;

// TODO MOVE TO SHARED KERNEL
public class Username extends ValueObject {

    private final String value;

    private Username(final String value) {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException(ErrorMessageConstants.USERNAME_ID_CANNOT_BE_NULL_OR_BLANK);
        this.value = value;
    }

    public static Username valueOf(final String value) {
        return new Username(value);
    }

    public String getValue() {
        return value;
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
