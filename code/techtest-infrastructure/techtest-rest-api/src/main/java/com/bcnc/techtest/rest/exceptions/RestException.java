package com.bcnc.techtest.rest.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class RestException extends Exception {
    private final String message;
    private final HttpStatus status;

}
