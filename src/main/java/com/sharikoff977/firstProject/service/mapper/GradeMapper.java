package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.GradeDTO;
import com.sharikoff977.firstProject.model.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SubjectMapper.class, StudentMapper.class})
public interface GradeMapper {
    @Mapping(source = "subject.id", target = "subjectId")
    @Mapping(source = "student.id", target = "studentId")
    GradeDTO toDTO(Grade grade);

    @Mapping(source = "subjectId", target = "subject")
    @Mapping(source = "studentId", target = "student")
    Grade toEntity(GradeDTO gradeDTO);
}
