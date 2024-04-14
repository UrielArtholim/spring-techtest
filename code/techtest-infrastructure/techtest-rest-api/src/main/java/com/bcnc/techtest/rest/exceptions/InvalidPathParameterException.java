package com.bcnc.techtest.rest.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPathParameterException extends RestException {
    public InvalidPathParameterException(String parameter) {
        super(parameter, HttpStatus.BAD_REQUEST);
    }
}
