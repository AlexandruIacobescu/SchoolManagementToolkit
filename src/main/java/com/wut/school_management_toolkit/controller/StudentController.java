package com.wut.school_management_toolkit.controller;

import com.wut.school_management_toolkit.entity.Student;
import com.wut.school_management_toolkit.repository.StudentRepository;
import com.wut.school_management_toolkit.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Student>> findAllStudents(){
        List<Student> students = studentService.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Student> createStudent(@RequestBody final Student student){
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updateStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") final Long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/find-by-firstname-and-lastname/{fname}/{lname}")
    public ResponseEntity<List<Student>> findStudentsByFirstNameAndLastName(@PathVariable("fname") final String fname,
                                                                            @PathVariable("lname") final String lname){
        List<Student> students = studentService.findStudentsByFirstNameAndLastName(fname, lname);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping("/find-if-year-of-study-greater-than/{yos}")
    public ResponseEntity<List<Student>> findStudentsWithYearOfStudyGreaterThan(@PathVariable("yos") final Integer yos){
        List<Student> students = studentService.findStudentsWithYearOfStudyGreaterThan(yos);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
