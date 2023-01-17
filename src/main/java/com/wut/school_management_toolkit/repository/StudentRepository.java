package com.wut.school_management_toolkit.repository;

import com.wut.school_management_toolkit.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Transactional
    void deleteStudentByStudentId(Long id);

    @Transactional
    List<Student> findStudentsByFirstNameAndLastName(String fname, String lname);

    @Transactional
    List<Student> findStudentsByYearOfStudyGreaterThan(int i);
}
