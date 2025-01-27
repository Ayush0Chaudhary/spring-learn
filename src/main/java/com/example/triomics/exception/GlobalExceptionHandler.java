package com.example.triomics.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler is a controller advice class that handles exceptions
 * thrown by the application globally. It provides a centralized exception 
 * handling mechanism across all controllers.
 * 
 * <p>Basically if the application throws an exception, then it can be handled here, by mapping the exception to a method that will handle it.</p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }
}
