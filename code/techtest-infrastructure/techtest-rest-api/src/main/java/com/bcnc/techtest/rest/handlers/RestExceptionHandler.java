package com.bcnc.techtest.rest.handlers;

import com.bcnc.techtest.rest.exceptions.RestException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public String handleRestException(RestException exception) {
        return "The code generated an exception:\n" +
          "\tException message: " +
          exception.getMessage() +
          "\n\tException status: " +
          exception.getStatus();
    }
}