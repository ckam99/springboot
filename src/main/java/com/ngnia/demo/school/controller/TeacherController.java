package com.ngnia.demo.school.controller;

import java.util.List;

import com.ngnia.demo.school.entity.Teacher;
import com.ngnia.demo.school.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school/teachers")
public class TeacherController {

    @Autowired
    TeacherService service;

    @GetMapping
    public List<Teacher> getSubjects() {
        return service.getAll();
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return service.create(teacher);
    }

    @GetMapping("/{teacherId}")
    public Teacher findById(@PathVariable Long teacherId) {
        return service.findById(teacherId);
    }

    @PostMapping("/create")
    public Boolean createManyTeachers(@RequestBody List<Teacher> teachers) {
        return service.createMany(teachers);
    }

}
