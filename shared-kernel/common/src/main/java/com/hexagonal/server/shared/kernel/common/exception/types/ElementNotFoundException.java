package com.hexagonal.server.shared.kernel.common.exception.types;

import java.util.NoSuchElementException;

public class ElementNotFoundException extends NoSuchElementException {

    public ElementNotFoundException(final String message) {
        super(message);
    }

}
