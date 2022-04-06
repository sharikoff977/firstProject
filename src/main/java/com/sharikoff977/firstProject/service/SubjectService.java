package com.sharikoff977.firstProject.service;

import com.sharikoff977.firstProject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    Subject save(Subject subject);

    List<Subject> findAll();

    Optional<Subject> findOne(Long id);

    void delete(Long id);
}
