package com.sharikoff977.firstProject.facades;

import com.sharikoff977.firstProject.facades.dto.SubjectDTO;

import java.util.List;
import java.util.Optional;

public interface SubjectFacade {

    SubjectDTO save(SubjectDTO subjectDTO);

    List<SubjectDTO> findAll();

    Optional<SubjectDTO> findOne(Long id);

    void delete(Long id);
}
