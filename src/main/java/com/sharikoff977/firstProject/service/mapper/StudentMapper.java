package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *Mapper for the entity {@link com.sharikoff977.firstProject.model.Student}
 * and its DTO {@link com.sharikoff977.firstProject.facades.dto.StudentDTO}
 * */
@Mapper(uses = {SchoolClassMapper.class}, componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, Student>{
    @Mapping(source = "schoolClass.id", target = "schoolClassId")
    @Mapping(source = "schoolClass.number", target = "schoolClassNumber")
    @Mapping(source = "schoolClass.letter", target = "schoolClassLetter")
    StudentDTO toDto(Student student);

    @Mapping(source = "schoolClassId", target = "schoolClass")
    Student toEntity(StudentDTO studentDTO);
}
