package com.wut.school_management_toolkit.repository;

import com.wut.school_management_toolkit.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Long> {
}
