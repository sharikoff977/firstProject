package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.model.Student;
import com.sharikoff977.firstProject.repo.StudentRepo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *Mapper for the entity {@link com.sharikoff977.firstProject.model.Student}
 * and its DTO {@link com.sharikoff977.firstProject.facades.dto.StudentDTO}
 * */
@Mapper(uses = {SchoolClassMapper.class}, componentModel = "spring")
public abstract class StudentMapper implements EntityMapper<StudentDTO, Student> {

    @Autowired
    private StudentRepo studentRepo;

    @Mapping(source = "schoolClassId", target = "schoolClassId")
    public abstract StudentDTO toDto(Student student);

    @Mapping(source = "schoolClassId", target = "schoolClassId"/*, qualifiedByName = "someMethod"*/)
    public abstract Student toEntity(StudentDTO studentDTO);

    public Student fromId(Long id) {
        return studentRepo.getById(id);
    }
}
