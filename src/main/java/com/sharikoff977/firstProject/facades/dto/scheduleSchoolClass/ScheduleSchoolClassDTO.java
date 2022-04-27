package com.sharikoff977.firstProject.facades.dto.scheduleSchoolClass;

import lombok.Data;

import java.util.List;

@Data
public class ScheduleSchoolClassDTO {

    private Long schoolClassId;
    private List<DayOfWeekDTO> days;

}
