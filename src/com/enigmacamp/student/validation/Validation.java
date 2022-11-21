package com.enigmacamp.student.validation;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.ResponseStatus;

@FunctionalInterface
public interface Validation {
    // Single Abstract Method
    boolean validate(Student student);
}
