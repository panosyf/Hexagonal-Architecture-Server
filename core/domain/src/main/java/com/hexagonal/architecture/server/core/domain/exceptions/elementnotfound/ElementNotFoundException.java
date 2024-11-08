package com.hexagonal.architecture.server.core.domain.exceptions.elementnotfound;

import java.util.NoSuchElementException;

public class ElementNotFoundException extends NoSuchElementException {

    public ElementNotFoundException(final String message) {
        super(message);
    }

}
