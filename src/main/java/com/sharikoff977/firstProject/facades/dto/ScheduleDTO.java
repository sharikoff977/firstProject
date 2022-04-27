package com.sharikoff977.firstProject.facades.dto;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
public class ScheduleDTO {
    private Long id;
    private Long schoolClassId;
    private Long subjectId;
    private Long teacherId;
    private Long schoolRoomId;
    private ZonedDateTime date;
    private DayOfWeek dayOfWeek;
    private Long lessonId;
}
