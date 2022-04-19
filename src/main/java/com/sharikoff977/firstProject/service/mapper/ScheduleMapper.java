package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.ScheduleDTO;
import com.sharikoff977.firstProject.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring", uses = {SchoolClassMapper.class, SubjectMapper.class})
public interface ScheduleMapper {

    @Mapping(source = "schoolClassId", target = "schoolClassId")
    @Mapping(source = "subjectId", target = "subjectId")
    ScheduleDTO toDto(Schedule schedule);

    @Mapping(source = "schoolClassId", target = "schoolClassId")
    @Mapping(source = "subjectId", target = "subjectId")
    Schedule toEntity(ScheduleDTO scheduleDTO);

}
