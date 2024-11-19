package com.hexagonal.architecture.server.core.domain.exceptions.elementnotfound;

import java.util.NoSuchElementException;

// TODO MOVE TO SHARED KERNEL
public class ElementNotFoundException extends NoSuchElementException {

    public ElementNotFoundException(final String message) {
        super(message);
    }

}
