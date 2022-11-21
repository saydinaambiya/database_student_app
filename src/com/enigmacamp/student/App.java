package com.enigmacamp.student;

import com.enigmacamp.student.model.Major;
import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.repository.StudentRepository;
import com.enigmacamp.student.repository.StudentRepositoryFileImpl;
import com.enigmacamp.student.repository.StudentRepositoryImpl;
import com.enigmacamp.student.service.StudentService;
import com.enigmacamp.student.service.StudentServiceImpl;
import com.enigmacamp.student.util.ResponseStatus;
import com.enigmacamp.student.validation.StudentValidationUtil;
import com.enigmacamp.student.validation.Validation;

import java.util.List;

public class App {
    public static void main(String[] args) {

//        StudentRepository repository = new StudentRepositoryImpl(5);
        StudentRepository repository = new StudentRepositoryFileImpl("/home/user/Documents/javaEnigma/database-student-app/student.csv", 5);
        Validation ageValidation = StudentValidationUtil.ageValidation(17);
        Validation nameLengthValidation = StudentValidationUtil.nameLengthValidation(3,20);
        StudentService service = new StudentServiceImpl(repository, ageValidation, nameLengthValidation);

        Student student1 = new Student("Andra", 18, new Major("tik"));
        Student student2 = new Student("Budi", 18, new Major("biologi"));
//        Student student3 = new Student("Baja", 16, new Major("biologi"));
//        Student student4 = new Student("Ba", 18, new Major("biologi"));
//        Student student5 = new Student("Budiman", 18, new Major("biologi"));

        //add student

//        service.unregisterStudent();

        System.out.println(service.getAllStudent().getData().toString());
//        service.registerStudent(student4);

//        ResponseStatus<Student> register = service.registerStudent(student3);
//        if (register.isSuccess()){
//            System.out.println(register.getData());
//        }else {
//            System.err.println(register.getMessage());
//        }

        //delete student
//        ResponseStatus<String> unregister = service.unregisterStudent();
//        if (unregister.isSuccess()){
//            System.out.println("Delete is success");
//        }else {
//            System.out.println(unregister.getMessage());
//        }

        //view all student
//        ResponseStatus<List<Student>> studentList = service.getAllStudent();
//        if(!studentList.isSuccess()){
//            System.err.println(studentList.getMessage());
//        }else {
//            for (Student s : studentList.getData()) {
//                System.out.println(s);
//        }

        }

        //view student by idx

//        ResponseStatus<Student> student = service.getStudentByIndex(1);
//        if (!student.isSuccess()){
//            System.err.println(student.getMessage());
//        }else {
//            System.out.println(student.getData());
//        }
    }

