package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    ResponseEntity<List<Student>> findAll() {
        return studentService.findallStudent();
    }

    @PutMapping("/{id}")
    ResponseEntity<Student> updateStudent(@PathVariable("id") int rollNo, String firstName, String lastName,
            String email) {
        return studentService.updateStudent(rollNo, firstName, lastName, email);
    }

    @DeleteMapping("/{rollNo}")
    ResponseEntity<String> deleteStudent(@PathVariable int rollNo) {
        return studentService.deleteStudent(rollNo);
    }

}
