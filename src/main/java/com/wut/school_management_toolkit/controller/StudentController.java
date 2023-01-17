package com.wut.school_management_toolkit.controller;

import com.wut.school_management_toolkit.entity.Student;
import com.wut.school_management_toolkit.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/get-all")
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/insert")
    public Student createStudent(@RequestBody final Student student){
        return studentRepository.saveAndFlush(student);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteStudentById(@PathVariable("id") final Long id){
        studentRepository.deleteStudentByStudentId(id);
    }

    @RequestMapping("/find-by-firstname-and-lastname/{fname}/{lname}")
    public List<Student> findStudentsByFirstNameAndLastName(@PathVariable("fname") final String fname,
                                                            @PathVariable("lname") final String lname){
        return studentRepository.findStudentsByFirstNameAndLastName(fname, lname);
    }

    @RequestMapping("/find-if-year-of-study-greater-than/{yos}")
    public List<Student> findStudentsWithYearOfStudyGreaterThan1(@PathVariable("yos") final Integer yos){
        return studentRepository.findStudentsByYearOfStudyGreaterThan(yos);
    }
}
