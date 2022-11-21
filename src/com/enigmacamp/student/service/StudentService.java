package com.enigmacamp.student.service;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.ResponseStatus;

import java.util.List;

public interface StudentService {
    ResponseStatus<Student> registerStudent(Student newStudent);
    ResponseStatus<String> unregisterStudent();

    ResponseStatus<List<Student>> getAllStudent();

    ResponseStatus<Student> getStudentByIndex(int idx);

}
