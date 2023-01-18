package com.wut.school_management_toolkit.service;

import com.wut.school_management_toolkit.entity.Student;
import com.wut.school_management_toolkit.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.saveAndFlush(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteStudentByStudentId(id);
    }

    public List<Student> findStudentsByFirstNameAndLastName(String fname, String lname){
        return studentRepository.findStudentsByFirstNameAndLastName(fname, lname);
    }

    public List<Student> findStudentsWithYearOfStudyGreaterThan(Integer yos){
        return studentRepository.findStudentsByYearOfStudyGreaterThan(yos);
    }
}
