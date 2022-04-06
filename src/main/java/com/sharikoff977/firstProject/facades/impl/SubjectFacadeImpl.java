package com.sharikoff977.firstProject.facades.impl;

import com.sharikoff977.firstProject.facades.SubjectFacade;
import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import com.sharikoff977.firstProject.model.Subject;
import com.sharikoff977.firstProject.service.SubjectService;
import com.sharikoff977.firstProject.service.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class SubjectFacadeImpl implements SubjectFacade {

    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectDTO save(SubjectDTO subjectDTO) {
        log.debug("Request to save Subject : ",subjectDTO);
        Subject subject = subjectMapper.toEntity(subjectDTO);
        subject = subjectService.save(subject);
        return subjectMapper.toDto(subject);
    }

    @Override
    public List<SubjectDTO> findAll() {
        log.debug("Request to find all subjects");
        //List<SubjectDTO> subjectDTO = subjectService.findAll().stream().map(subjectMapper::toDto).collect(Collectors.toList());
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for (Subject s : subjectService.findAll()) {
            SubjectDTO subjectDTO = subjectMapper.toDto(s);
            subjectDTOList.add(subjectDTO);
        }
        return subjectDTOList;
    }

    @Override
    public Optional<SubjectDTO> findOne(Long id) {
        log.debug("Request to find subject by id : {}", id);
        Subject subject = subjectService.findOne(id).get();
        SubjectDTO subjectDTO = subjectMapper.toDto(subject);
        return Optional.of(subjectDTO);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete subject by id : {}", id);
        subjectService.delete(id);
    }

}
