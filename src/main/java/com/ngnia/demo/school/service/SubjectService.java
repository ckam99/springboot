package com.ngnia.demo.school.service;

import java.util.List;

import com.ngnia.demo.school.entity.Student;
import com.ngnia.demo.school.entity.Subject;
import com.ngnia.demo.school.entity.Teacher;
import com.ngnia.demo.school.repository.StudentRepository;
import com.ngnia.demo.school.repository.SubjectRepository;
import com.ngnia.demo.school.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository repository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public List<Subject> getAll() {
        return repository.findAll();
    }

    public Subject create(Subject subject) {
        return repository.save(subject);
    }

    public Subject findById(Long subjectId) {
        return repository.findById(subjectId).orElse(null);
    }

    public Boolean createMany(List<Subject> subjects) {
        for (Subject subject : subjects) {
            repository.save(subject);
        }
        return true;
    }

    public Subject enrollStudent(Long subjectId, Long studentId) {
        Subject subject = repository.findById(subjectId).orElseThrow(null);
        Student student = studentRepository.findById(studentId).orElse(null);
        subject.enrollStudent(student);
        return repository.save(subject);
    }

    public Subject assignTeacherToSubject(Long subjectId, Long teacherId) {
        Subject subject = repository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.setTeacher(teacher);
        return repository.save(subject);
    }

}
