package com.example.triomics.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a requested resource is not found.
 * 
 * <p>This exception is annotated with {@code @ResponseStatus(HttpStatus.NOT_FOUND)},
 * which will cause Spring to respond with a 404 Not Found status code when this
 * exception is thrown.</p>
 * 
 * <p>It extends {@code RuntimeException}, so it is an unchecked exception.</p>
 * 
 * @see org.springframework.web.bind.annotation.ResponseStatus
 * @see org.springframework.http.HttpStatus
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
