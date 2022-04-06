package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.model.Grade;
import com.sharikoff977.firstProject.repo.GradeRepo;
import com.sharikoff977.firstProject.service.GradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
//@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepo gradeRepo;

    public GradeServiceImpl(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    @Override
    public Grade save(Grade grade) {
        return gradeRepo.save(grade);
    }

    @Override
    public List<Grade> findAll() {
        return gradeRepo.findAll();
    }

    @Override
    public Optional<Grade> findOne(Long id) {
        return gradeRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        gradeRepo.deleteById(id);
    }
}
