package com.hexagonal.architecture.server.core.domain.exceptions.utils;

public abstract class ErrorUtils {

    private ErrorUtils() {}

    public static String generateErrorMessage(final String message) {
        return message;
    }

    public static String generateErrorMessage(final String message, final String id) {
        return String.format(message, id);
    }

}
