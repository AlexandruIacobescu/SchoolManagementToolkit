package com.wut.school_management_toolkit.repository;

import com.wut.school_management_toolkit.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
}
