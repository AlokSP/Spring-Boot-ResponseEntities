package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        Student savedStudent = repo.save(student);
        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Student>> findallStudent() {
        List<Student> students = repo.findAll();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student> updateStudent(int rollNo, String firstName, String lastName, String email) {
        Student student = repo.findById(rollNo).get();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        Student savedStudent = repo.save(student);

        return new ResponseEntity<Student>(savedStudent, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteStudent(int id) {
        Student student = repo.findById(id).get();
        repo.delete(student);
        return new ResponseEntity<String>("Delted Successfully", HttpStatus.OK);
    }

}
