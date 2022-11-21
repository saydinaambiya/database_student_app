package com.enigmacamp.student.validation;

import com.enigmacamp.student.model.Student;

public abstract class StudentValidationUtil {
    public static Validation ageValidation(int minAge) {
        return (Student student) -> student.getAge() >= minAge;
    }

    public static Validation nameLengthValidation(int minLenght, int maxLenght) {
        return (Student student) -> student.getName().length()>=minLenght && student.getName().length()<=maxLenght;
    }
}
