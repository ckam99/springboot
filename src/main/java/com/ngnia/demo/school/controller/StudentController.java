package com.ngnia.demo.school.controller;

import java.util.List;

import com.ngnia.demo.school.entity.Student;
import com.ngnia.demo.school.response.StudentResponse;
import com.ngnia.demo.school.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school/students")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public ResponseEntity<?> getStudents() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.create(student);
    }

    @GetMapping("/{studentId}")
    public Student findById(@PathVariable Long studentId) {
        return service.findById(studentId);
    }

    @PostMapping("/create")
    public Boolean createManyStudents(@RequestBody List<Student> students) {
        return service.createMany(students);
    }

}
