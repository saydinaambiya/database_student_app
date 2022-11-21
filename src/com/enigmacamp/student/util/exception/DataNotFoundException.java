package com.enigmacamp.student.util.exception;

import com.enigmacamp.student.util.StatusMessage;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException() {
        super(StatusMessage.DATA_IS_EMPTY.toString());
    }
}
