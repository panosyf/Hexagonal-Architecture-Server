package com.hexagonal.architecture.server.core.domain.valueobjects;

import java.util.Objects;

public class Email extends ValueObject {

    private final String value;

    private Email(String value) {
        this.value = value;
    }

    private Email(String name, String mailServer, String domain) {
        this.value = generateValue(name, mailServer, domain);
    }

    public static Email valueOf(String value) {
        return new Email(value);
    }

    public static Email valueOf(String name, String mailServer, String domain) {
        return new Email(name, mailServer, domain);
    }

    public String getValue() {
        return this.value;
    }

    private String generateValue(String name, String mailServer, String domain) {
        return name + "@" + mailServer + "." + domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Email{" +
                "value='" + value + '\'' +
                '}';
    }

}
