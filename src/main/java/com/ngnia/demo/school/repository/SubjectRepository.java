package com.ngnia.demo.school.repository;

import com.ngnia.demo.school.entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
