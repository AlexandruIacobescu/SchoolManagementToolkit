package com.wut.school_management_toolkit.repository;

import com.wut.school_management_toolkit.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
