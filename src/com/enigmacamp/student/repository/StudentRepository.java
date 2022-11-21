package com.enigmacamp.student.repository;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.ResponseStatus;

import java.util.List;

public interface StudentRepository {

    Student add(Student student);
    List<Student> findAll();
    void delete();
    Student findByIndex(int idx);
}
