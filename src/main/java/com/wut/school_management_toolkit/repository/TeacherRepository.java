package com.wut.school_management_toolkit.repository;

import com.wut.school_management_toolkit.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
