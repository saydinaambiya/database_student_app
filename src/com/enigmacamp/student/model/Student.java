package com.enigmacamp.student.model;

import java.util.Arrays;

public class Student {
    private String name;
    private Integer age;
    private Major major;

    public Student(String name, int age, Major major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }

    public String toCsv(){
        return String.join(",", Arrays.asList(name, age.toString(), major.getMajorName()))+"\n";
    }
}
