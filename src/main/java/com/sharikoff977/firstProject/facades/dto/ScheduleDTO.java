package com.sharikoff977.firstProject.facades.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;

@Data
public class ScheduleDTO {
    private Long id;
    private Long schoolClassId;
    private Long subjectId;
    private ZonedDateTime date;
}
