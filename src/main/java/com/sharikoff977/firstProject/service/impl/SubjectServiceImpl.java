package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.model.Subject;
import com.sharikoff977.firstProject.repo.StudentRepo;
import com.sharikoff977.firstProject.repo.SubjectRepo;
import com.sharikoff977.firstProject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepo subjectRepo;

    @Override
    public Subject save(Subject subject) {
        log.debug("Request to save Subject");
        return subjectRepo.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        log.debug("Request to find all Subjects");
        return subjectRepo.findAll();
    }

    @Override
    public Optional<Subject> findOne(Long id) {
        log.debug("Request to find Subject by id : {}", id);
        return subjectRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Subject by id : ", id);
        subjectRepo.deleteById(id);
    }
}
