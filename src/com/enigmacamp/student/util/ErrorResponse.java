package com.enigmacamp.student.util;

public class ErrorResponse extends ResponseStatus{

    public ErrorResponse(String error) {
        super(false, error, null);
    }
}
