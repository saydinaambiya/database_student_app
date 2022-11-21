package com.enigmacamp.student.service;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.repository.StudentRepository;
import com.enigmacamp.student.util.ErrorResponse;
import com.enigmacamp.student.util.ResponseStatus;
import com.enigmacamp.student.util.StatusMessage;
import com.enigmacamp.student.util.SuccessResponse;
import com.enigmacamp.student.validation.Validation;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;
    private Validation ageValidation;
    private Validation nameLengthValidation;

    public StudentServiceImpl(StudentRepository repository, Validation ageValidation, Validation nameLengthValidation) {
        this.repository = repository;
        this.ageValidation = ageValidation;
        this.nameLengthValidation = nameLengthValidation;
    }

    @Override
    public ResponseStatus<Student> registerStudent(Student newStudent) {
        if(!this.ageValidation.validate(newStudent)) return new ErrorResponse(StatusMessage.INVALID_AGE.toString());
        if(!this.nameLengthValidation.validate(newStudent)) return new ErrorResponse(StatusMessage.INVALID_LENGTH_NAME.toString());
        try {
            Student student = repository.add(newStudent);
            return new SuccessResponse<>(student);
        }catch (Exception e){
            return new ErrorResponse(e.getMessage());
        }
    }

    @Override
    public ResponseStatus<List<Student>> getAllStudent() {
        try {
            return new SuccessResponse<>(repository.findAll());
        }catch (Exception e){
            return new ErrorResponse(e.getMessage());
        }
    }

    @Override
    public ResponseStatus<String> unregisterStudent() {
        try {
            repository.delete();
            return new SuccessResponse<String>(StatusMessage.SUCCESS.toString());
        }catch (Exception e){
            return new ErrorResponse(e.getMessage());
        }
    }

    @Override
    public ResponseStatus<Student> getStudentByIndex(int idx) {
        try {
            return new SuccessResponse<>(repository.findByIndex(idx));
        }catch (Exception e){
            return new ErrorResponse(e.getMessage());
        }

    }
}
