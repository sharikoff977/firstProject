package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.LessonDTO;
import com.sharikoff977.firstProject.model.Lesson;
import com.sharikoff977.firstProject.model.SchoolClass;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonDTO toDto(Lesson lesson);

    Lesson toEntity(LessonDTO lessonDTO);

    default Lesson fromId(Long id) {
        if (id == null) {
            return null;
        }
        Lesson lesson = new Lesson();
        lesson.setId(id);
        return lesson;
    }

}
