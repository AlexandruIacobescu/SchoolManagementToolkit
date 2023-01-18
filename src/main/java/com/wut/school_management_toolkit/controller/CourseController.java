package com.wut.school_management_toolkit.controller;

import com.wut.school_management_toolkit.entity.Course;
import com.wut.school_management_toolkit.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/get-all")
    public ResponseEntity<List<Course>> findAllCourses(){
        List<Course> courses = courseService.findAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course newCourse = courseService.addCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.OK);
    }

    @DeleteMapping("delete-by-id/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable("id") Long courseId){
        try{
            courseService.deleteCourseById(courseId);
        } catch(EmptyResultDataAccessException ex){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
