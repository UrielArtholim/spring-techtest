package com.bcnc.techtest.rest.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends RestException {

    public NotFoundException() {
        super(HttpStatus.NOT_FOUND, "Item not found" );
    }
}
