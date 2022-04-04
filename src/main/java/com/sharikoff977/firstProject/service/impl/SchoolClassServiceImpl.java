package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.repo.SchoolClassRepo;
import com.sharikoff977.firstProject.service.SchoolClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link com.sharikoff977.firstProject.service.SchoolClassService}.
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SchoolClassServiceImpl implements SchoolClassService {

    private final SchoolClassRepo schoolClassRepo;

    @Override
    public SchoolClass save(SchoolClass schoolClass) {
        log.debug("Request to save SchoolClass : {}", schoolClass);
        return schoolClassRepo.save(schoolClass);
    }

    @Override
    public List<SchoolClass> findAll() {
        log.debug("Request to get all SchoolClasses");
        return schoolClassRepo.findAll();
    }

    @Override
    public Optional<SchoolClass> findOne(Long id) {
        log.debug("Request to get SchoolClass : {}", id);
        return schoolClassRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SchoolClass : {}", id);
        schoolClassRepo.deleteById(id);
    }
}
