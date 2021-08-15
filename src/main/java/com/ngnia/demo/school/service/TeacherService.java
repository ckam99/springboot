package com.ngnia.demo.school.service;

import java.util.List;

import com.ngnia.demo.school.entity.Teacher;
import com.ngnia.demo.school.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repository;

    public List<Teacher> getAll() {
        return repository.findAll();
    }

    public Teacher create(Teacher teacher) {
        return repository.save(teacher);
    }

    public Teacher findById(Long teacherId) {
        return repository.findById(teacherId).orElse(null);
    }

    public Boolean createMany(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            repository.save(teacher);
        }
        return true;
    }

}
