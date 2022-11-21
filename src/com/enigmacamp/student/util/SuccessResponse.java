package com.enigmacamp.student.util;

public class SuccessResponse<T> extends ResponseStatus{
    public SuccessResponse(T data) {

        super(true, null, data);
    }
}
