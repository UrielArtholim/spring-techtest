package com.bcnc.techtest.rest.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RestException {
    public NotFoundException() {
        super("The specified item cannot be found", HttpStatus.NOT_FOUND);
    }
}
