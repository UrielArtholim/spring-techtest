package com.bcnc.techtest.rest.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class RestException extends Throwable {
    protected final HttpStatus status;
    protected final String message;
}
