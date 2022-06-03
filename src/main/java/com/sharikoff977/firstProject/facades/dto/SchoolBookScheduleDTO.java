package com.sharikoff977.firstProject.facades.dto;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;

@Data
public class SchoolBookScheduleDTO {

    private Long id;
    private Long schoolClassId;
    private Long subjectId;
    private Long teacherId;
    private Long schoolRoomId;
    private ZonedDateTime date;

}
