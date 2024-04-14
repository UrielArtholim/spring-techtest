package com.bcnc.techtest.rest.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class AlreadyExistsException extends RestException {

    public AlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Current item already exists" );
    }
}
