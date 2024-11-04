package com.hexagonal.architecture.server.core.domain.valueobjects;

import java.util.Objects;

public class Name extends ValueObject {

    private String firstName;
    private String lastName;

    private Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Name valueOf(final String firstName, final String lastName) {
        validateInputs(firstName, lastName);
        return new Name(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateValueNotNull(firstName, "firstName cannot be null");
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateValueNotNull(lastName, "lastName cannot be null");
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    private static void validateInputs(String firstName, String lastName) {
        validateValueNotNull(firstName, "firstName cannot be null");
        validateValueNotNull(lastName, "lastName cannot be null");
    }

    private static void validateValueNotNull(String value, String errorMessage) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException(errorMessage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
