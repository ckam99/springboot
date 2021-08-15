package com.ngnia.demo.school.repository;

import com.ngnia.demo.school.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
