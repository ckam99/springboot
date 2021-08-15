package com.ngnia.demo.school.service;

import java.util.List;

import com.ngnia.demo.school.entity.Student;
import com.ngnia.demo.school.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student findById(Long studentId) {
        return repository.findById(studentId).orElse(null);
    }

    public Student create(Student student) {
        return repository.save(student);
    }

    public Boolean createMany(List<Student> students) {
        for (Student student : students) {
            repository.save(student);
        }
        return true;
    }

}
