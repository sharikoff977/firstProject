package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.model.Subject;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface SubjectMapper {

    SubjectDTO toDto(Subject subject);

    Subject toEntity(SubjectDTO subjectDTO);

    default Subject fromId(Long id) {
        if (id == null) {
            return null;
        }
        Subject subject = new Subject();
        subject.setId(id);
        return subject;
    }
}
