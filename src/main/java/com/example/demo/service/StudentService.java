package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Student;

public interface StudentService {

    ResponseEntity<Student> createStudent(Student student);

    ResponseEntity<List<Student>> findallStudent();

    ResponseEntity<String> deleteStudent(int id);

    ResponseEntity<Student> updateStudent(int rollNo, String firstName, String lastName, String email);

}
