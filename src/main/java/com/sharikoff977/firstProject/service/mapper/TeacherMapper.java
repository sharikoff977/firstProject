package com.sharikoff977.firstProject.service.mapper;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;
import com.sharikoff977.firstProject.facades.dto.TeacherDTO;
import com.sharikoff977.firstProject.model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherDTO toDto(Teacher teacher);

    Teacher toEntity(TeacherDTO teacherDTO);

}
