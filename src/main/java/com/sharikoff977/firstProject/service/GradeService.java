package com.sharikoff977.firstProject.service;

import com.sharikoff977.firstProject.model.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    Grade save(Grade grade);

    List<Grade> findAll();

    Optional<Grade> findOne(Long id);

    void delete(Long id);
}
