package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.SchoolClassDTO;
import com.sharikoff977.firstProject.model.SchoolClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link com.sharikoff977.firstProject.model.SchoolClass}
 * and its DTO {@link com.sharikoff977.firstProject.facades.dto.SchoolClassDTO}.
 */

@Mapper(componentModel = "spring")
public interface SchoolClassMapper {
    //@Mapping(target = "students", ignore = true)

    SchoolClass toEntity(SchoolClassDTO schoolClassDTO);
    SchoolClassDTO toDTO(SchoolClass schoolClass);
}
