package com.enigmacamp.student.util.exception;

import com.enigmacamp.student.util.StatusMessage;

public class CapacityException extends RuntimeException{
    public CapacityException() {
        super(StatusMessage.NOT_ENOUGH_SPACE.toString());
    }
}
