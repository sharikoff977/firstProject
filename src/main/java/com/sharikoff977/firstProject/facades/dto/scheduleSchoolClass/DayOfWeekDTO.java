package com.sharikoff977.firstProject.facades.dto.scheduleSchoolClass;

import com.sharikoff977.firstProject.model.enumeration.DayOfWeekEnum;
import lombok.Data;

import java.time.DayOfWeek;
import java.util.List;

@Data
public class DayOfWeekDTO {

    private DayOfWeek day;
    private List<LessonDTO> lessons;

}
