package com.ngnia.demo.school.repository;

import com.ngnia.demo.school.entity.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
