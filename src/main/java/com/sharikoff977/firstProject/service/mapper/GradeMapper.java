package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.GradeDTO;
import com.sharikoff977.firstProject.model.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SchoolBookScheduleMapper.class, StudentMapper.class})
public interface GradeMapper {
    @Mapping(source = "schoolBookSchedule.id", target = "schoolBookScheduleId")
    @Mapping(source = "student.id", target = "studentId")
    GradeDTO toDto(Grade grade);

    @Mapping(source = "schoolBookScheduleId", target = "schoolBookSchedule")
    @Mapping(source = "studentId", target = "student"/*, qualifiedByName = {"StudentMapper", "fromId"}*/)
    Grade toEntity(GradeDTO gradeDTO);



}
