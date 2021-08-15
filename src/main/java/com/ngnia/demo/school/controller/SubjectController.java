package com.ngnia.demo.school.controller;

import java.util.List;

import com.ngnia.demo.school.entity.Subject;
import com.ngnia.demo.school.response.ResponseError;
import com.ngnia.demo.school.response.StudentResponse;
import com.ngnia.demo.school.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school/subjects")
public class SubjectController {

    @Autowired
    SubjectService service;

    @GetMapping
    public ResponseEntity<?> getSubjects() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSubject(@RequestBody Subject subject) {
        try {
            return new ResponseEntity<>(service.create(subject), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseError(e.getMessage()));
        }
    }

    @PostMapping("/create")
    public Boolean createManySubjects(@RequestBody List<Subject> subjects) {
        return service.createMany(subjects);
    }

    @PutMapping("/{subjectId}/student/{studentId}")
    public Subject enroleStudent(@PathVariable Long subjectId, @PathVariable Long studentId) {
        return service.enrollStudent(subjectId, studentId);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {
        return service.assignTeacherToSubject(subjectId, teacherId);
    }

    @GetMapping("/{subjectId}")
    public Subject findById(@PathVariable Long subjectId) {
        return service.findById(subjectId);
    }

}
