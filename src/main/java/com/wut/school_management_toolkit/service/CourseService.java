package com.wut.school_management_toolkit.service;

import com.wut.school_management_toolkit.entity.Course;
import com.wut.school_management_toolkit.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course){
        return courseRepository.saveAndFlush(course);
    }

    public void deleteCourseById(Long courseId){
        courseRepository.deleteById(courseId);
    }

    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }
}
