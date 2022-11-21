package com.enigmacamp.student.repository;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.StatusMessage;
import com.enigmacamp.student.util.ErrorResponse;
import com.enigmacamp.student.util.ResponseStatus;
import com.enigmacamp.student.util.SuccessResponse;
import com.enigmacamp.student.util.exception.CapacityException;
import com.enigmacamp.student.util.exception.EmptyListException;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private List<Student> studentList = new ArrayList<>();
    private int maxData;

    public StudentRepositoryImpl(int maxData) {
        this.maxData = maxData;
    }

    @Override
    public Student add(Student student) {
        if (!(studentList.size() < maxData)) {
            throw new CapacityException();
        }
        studentList.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        if (studentList.isEmpty()) {
            throw new EmptyListException();
        }
        return studentList;
    }

    @Override
    public Student findByIndex(int idx) {
        if (idx >= 0 && idx < studentList.size()) {
            return studentList.get(idx);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void delete() {
        if (studentList.isEmpty()) {
            throw new EmptyListException();
        }
        studentList.remove(studentList.size() - 1);
    }
}
