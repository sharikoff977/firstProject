package com.sharikoff977.firstProject.facades.impl;

import com.sharikoff977.firstProject.facades.SchoolClassFacade;
import com.sharikoff977.firstProject.facades.dto.SchoolClassDTO;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.service.SchoolClassService;
import com.sharikoff977.firstProject.service.mapper.SchoolClassMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Facade Implementation for managing {@link com.sharikoff977.firstProject.model.SchoolClass}.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class SchoolClassFacadeImpl implements SchoolClassFacade {

    private final SchoolClassMapper schoolClassMapper;
    private final SchoolClassService schoolClassService;

    @Override
    public SchoolClassDTO save(SchoolClassDTO schoolClassDTO) {
        log.debug("Request to save Article : {}", schoolClassDTO);
        SchoolClass schoolClass = schoolClassMapper.toEntity(schoolClassDTO);
        schoolClass = schoolClassService.save(schoolClass);
        return schoolClassMapper.toDto(schoolClass);
    }

    @Override
    public List<SchoolClassDTO> findAll() {
        log.debug("Request to get all Articles");
        return schoolClassService.findAll().stream().map(schoolClassMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<SchoolClassDTO> findOne(Long id) {
        log.debug("Request to get Article : {}", id);
        return schoolClassService.findOne(id).map(schoolClassMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Article : {}", id);
        schoolClassService.delete(id);
    }
}
