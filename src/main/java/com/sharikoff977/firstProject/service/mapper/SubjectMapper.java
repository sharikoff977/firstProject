package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import com.sharikoff977.firstProject.model.Subject;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface SubjectMapper {

    SubjectDTO toDto(Subject subject);

    Subject toEntity(SubjectDTO subjectDTO);
}
