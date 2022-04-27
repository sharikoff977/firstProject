package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.ScheduleDTO;
import com.sharikoff977.firstProject.model.Lesson;
import com.sharikoff977.firstProject.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring", uses = {SchoolClassMapper.class, SubjectMapper.class, Lesson.class})
public interface ScheduleMapper {

    @Mapping(source = "schoolClassId", target = "schoolClassId")
    @Mapping(source = "subjectId", target = "subjectId")
    @Mapping(source = "lesson.id", target = "lessonId")
    ScheduleDTO toDto(Schedule schedule);

    @Mapping(source = "schoolClassId", target = "schoolClassId")
    @Mapping(source = "subjectId", target = "subjectId")
    @Mapping(source = "lessonId", target = "lesson.id")
    Schedule toEntity(ScheduleDTO scheduleDTO);

}
