package com.enigmacamp.student.repository;

import com.enigmacamp.student.model.Major;
import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.exception.CapacityException;
import com.enigmacamp.student.util.exception.EmptyListException;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentRepositoryFileImpl implements StudentRepository {

    private final Path path;
    private int maxData;

    public StudentRepositoryFileImpl(String path, int maxData) {
        try {
            this.path = Paths.get(path);
            boolean newFileExists = Files.exists(this.path);
            if (!newFileExists) {
                Files.createFile(this.path);
            }
            this.maxData = maxData;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private Stream<String> readData() {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeData(String content) {
        try {
            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertData(String content) {
        try {
            Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student add(Student student) {
        long totalLines = readData().count();
        if (!(totalLines < maxData)) throw new CapacityException();
        insertData(student.toCsv());
        return student;
    }

    @Override
    public List<Student> findAll() {
        return readData().map(s -> {
            String[] studentString = s.split(",");
            return new Student(studentString[0], Integer.valueOf(studentString[1]), new Major(studentString[2]));
        }).collect(Collectors.toList());
    }

    @Override
    public void delete() {
        List result = readData().sorted(Comparator.reverseOrder()).skip(1).collect(Collectors.toList());
        if (result.isEmpty()){
            throw new EmptyListException();
        }
        writeData(String.join("\n", result));
    }

    @Override
    public Student findByIndex(int idx) {
        return null;
    }
}
