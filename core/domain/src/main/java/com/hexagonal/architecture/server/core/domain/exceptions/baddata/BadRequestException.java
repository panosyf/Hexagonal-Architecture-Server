package com.hexagonal.architecture.server.core.domain.exceptions.baddata;

public class BadRequestException extends RuntimeException {

    public BadRequestException(final String message) {
        super(message);
    }

}
