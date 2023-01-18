package com.wut.school_management_toolkit.service;

import com.wut.school_management_toolkit.entity.Grade;
import com.wut.school_management_toolkit.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> findAllGrades(){
        return gradeRepository.findAll();
    }

    public Optional<Grade> findGradeById(Long gradeId){
        return gradeRepository.findById(gradeId);
    }
}
