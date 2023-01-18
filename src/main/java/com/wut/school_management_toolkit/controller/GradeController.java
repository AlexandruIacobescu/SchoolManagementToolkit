package com.wut.school_management_toolkit.controller;

import com.wut.school_management_toolkit.entity.Grade;
import com.wut.school_management_toolkit.service.GradeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @RequestMapping("/get-by-id/{id}")
    public ResponseEntity<Optional<Grade>> findGradeById(@PathVariable("id") Long gradeId){
        Optional<Grade> grade = gradeService.findGradeById(gradeId);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @RequestMapping("/get-all")
    public ResponseEntity<List<Grade>> findAllGrades(){
        List<Grade> grades = gradeService.findAllGrades();
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }
}
