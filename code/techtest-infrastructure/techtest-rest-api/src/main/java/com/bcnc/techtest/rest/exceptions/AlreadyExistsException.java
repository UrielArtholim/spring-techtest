package com.bcnc.techtest.rest.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends RestException {
    public AlreadyExistsException() {
        super("The specified item already exists ", HttpStatus.CONFLICT);
    }
}
