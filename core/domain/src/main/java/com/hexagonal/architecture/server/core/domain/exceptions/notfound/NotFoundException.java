package com.hexagonal.architecture.server.core.domain.exceptions.notfound;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

}
