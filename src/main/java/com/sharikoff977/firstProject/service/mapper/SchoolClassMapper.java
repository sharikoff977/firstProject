package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.SchoolClassDTO;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.model.Student;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
 * Mapper for the entity {@link com.sharikoff977.firstProject.model.SchoolClass}
 * and its DTO {@link com.sharikoff977.firstProject.facades.dto.SchoolClassDTO}.
 */

@Mapper(componentModel = "spring")
public interface SchoolClassMapper extends EntityMapper<SchoolClassDTO, SchoolClass> {

    @Mapping(target = "students", ignore = true)
    SchoolClass toEntity(SchoolClassDTO schoolClassDTO);
    List<SchoolClassDTO> toDto(List<SchoolClass> schoolClass);

    default SchoolClass fromId(Long id) {
        if (id == null) {
            return null;
        }
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setId(id);
        return schoolClass;
    }
}
