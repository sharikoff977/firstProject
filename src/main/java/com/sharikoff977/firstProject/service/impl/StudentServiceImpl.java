package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.model.Student;
import com.sharikoff977.firstProject.repo.StudentRepo;
import com.sharikoff977.firstProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing {@link com.sharikoff977.firstProject.model.Student}
 * */
@Service
//@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public Student save(Student student) {
        log.debug("Request to save student : {}", student);
        return studentRepo.save(student);
    }

    @Override
    public List<Student> findAll() {
        log.debug("Request to find all students");
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> findOne(Long id) {
        log.debug("Request to get student : {}", id);
        return studentRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete student : {}", id);
        studentRepo.deleteById(id);
    }
}
