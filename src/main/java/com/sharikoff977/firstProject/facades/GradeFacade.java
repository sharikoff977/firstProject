package com.sharikoff977.firstProject.facades;

import com.sharikoff977.firstProject.facades.dto.GradeDTO;

import java.util.List;
import java.util.Optional;

public interface GradeFacade {
    GradeDTO save(GradeDTO gradeDTO);

    List<GradeDTO> findAll();

    Optional<GradeDTO> findOne(Long id);

    void delete(Long id);
}
