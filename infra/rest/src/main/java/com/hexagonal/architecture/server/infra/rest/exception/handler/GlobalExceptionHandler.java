package com.hexagonal.architecture.server.infra.rest.exception.handler;

import com.hexagonal.architecture.server.core.domain.exceptions.illegalargument.IllegalArgumentException;
import com.hexagonal.architecture.server.core.domain.exceptions.elementnotfound.ElementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// TODO MOVE TO SHARED KERNEL
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ElementNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(final ElementNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Object> handleBadRequestException(final IllegalArgumentException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

}
