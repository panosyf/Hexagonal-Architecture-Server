package com.hexagonal.architecture.server.core.domain.valueobjects;

import com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants;

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
        validateValue(value, ErrorMessageConstants.EMAIL_VALUE_CANNOT_BE_NULL_OR_BLANK);
        return new Email(value);
    }

    public static Email valueOf(String name, String mailServer, String domain) {
        validateInputs(name, mailServer, domain);
        return new Email(name, mailServer, domain);
    }

    private static void validateInputs(String name, String mailServer, String domain) {
        validateValue(name, ErrorMessageConstants.EMAIL_NAME_CANNOT_BE_NULL_OR_BLANK);
        validateValue(mailServer, ErrorMessageConstants.EMAIL_MAIL_SERVER_CANNOT_BE_NULL_OR_BLANK);
        validateValue(domain, ErrorMessageConstants.EMAIL_DOMAIN_CANNOT_BE_NULL_OR_BLANK);
    }

    public String getValue() {
        return this.value;
    }

    private String generateValue(String name, String mailServer, String domain) {
        return name + "@" + mailServer + "." + domain;
    }

    private static void validateValue(String value, String value_is_null) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException(value_is_null);
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
