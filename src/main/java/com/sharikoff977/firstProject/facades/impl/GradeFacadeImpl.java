package com.sharikoff977.firstProject.facades.impl;

import com.sharikoff977.firstProject.facades.GradeFacade;
import com.sharikoff977.firstProject.facades.dto.GradeDTO;
import com.sharikoff977.firstProject.model.Grade;
import com.sharikoff977.firstProject.service.GradeService;
import com.sharikoff977.firstProject.service.mapper.GradeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class GradeFacadeImpl implements GradeFacade {

    private final GradeMapper gradeMapper;
    private final GradeService gradeService;

    @Override
    public GradeDTO save(GradeDTO gradeDTO) {
        Grade grade = gradeMapper.toEntity(gradeDTO);
        grade = gradeService.save(grade);
        return gradeMapper.toDTO(grade);
    }

    @Override
    public List<GradeDTO> findAll() {
        List<GradeDTO> result = new ArrayList<>();
        for (Grade grade : gradeService.findAll()) {
            GradeDTO gradeDTO = gradeMapper.toDTO(grade);
            result.add(gradeDTO);
        }
        return result;
    }

    @Override
    public Optional<GradeDTO> findOne(Long id) {
        Grade grade = gradeService.findOne(id).get();
        GradeDTO gradeDTO = gradeMapper.toDTO(grade);
        return Optional.of(gradeDTO);
    }

    @Override
    public void delete(Long id) {
        gradeService.delete(id);
    }
}
