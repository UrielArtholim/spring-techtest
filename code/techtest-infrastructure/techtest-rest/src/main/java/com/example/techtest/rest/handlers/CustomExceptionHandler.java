package com.example.techtest.rest.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ControllerAdvice
@Qualifier("customExceptionHandler")
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND) // 404
    @ExceptionHandler(NoResourceFoundException.class)
    public void handleNotFound(NoResourceFoundException ex) {
        log.error("Requested element not found");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(IllegalArgumentException.class)
    public void handleBadRequest(IllegalArgumentException ex) {
        log.error("Invalid argument in request");
    }


    @ResponseStatus(HttpStatus.CONFLICT) // 404
    @ExceptionHandler(UnsupportedOperationException.class)
    public void handleConflict(UnsupportedOperationException ex) {
        log.error("Requested element not found");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler(Exception.class)
    public void handleGeneralError(Exception ex) {
        log.error("An error occurred processing request" + ex);
    }
}