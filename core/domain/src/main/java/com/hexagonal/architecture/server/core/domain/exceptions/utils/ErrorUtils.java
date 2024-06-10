package com.hexagonal.architecture.server.core.domain.exceptions.utils;

public abstract class ErrorUtils {

    private ErrorUtils() {}

    public static String generateErrorMessage(String message) {
        return message;
    }

    public static String generateErrorMessage(String message, String id) {
        return String.format(message, id);
    }

}
