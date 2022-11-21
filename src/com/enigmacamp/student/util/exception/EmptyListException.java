package com.enigmacamp.student.util.exception;

import com.enigmacamp.student.util.StatusMessage;

public class EmptyListException extends RuntimeException{
    public EmptyListException() {
        super(StatusMessage.DATA_IS_EMPTY.toString());
    }
}
