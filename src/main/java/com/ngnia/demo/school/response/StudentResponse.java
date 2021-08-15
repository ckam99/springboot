package com.ngnia.demo.school.response;

import java.util.HashSet;
import java.util.Set;

import com.ngnia.demo.school.entity.Student;
import com.ngnia.demo.school.entity.Subject;

public class StudentResponse {

    private final Long id;
    private final String name;
    private final Set<Subject> subjects = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Set<Subject> getSubjects() {
        return this.subjects;
    }

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.subjects.addAll(student.getSubjects());
    }

}
