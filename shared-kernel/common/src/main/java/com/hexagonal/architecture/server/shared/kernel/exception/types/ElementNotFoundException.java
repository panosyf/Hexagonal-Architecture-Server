package com.hexagonal.architecture.server.shared.kernel.exception.types;

import java.util.NoSuchElementException;

public class ElementNotFoundException extends NoSuchElementException {

    public ElementNotFoundException(final String message) {
        super(message);
    }

}
