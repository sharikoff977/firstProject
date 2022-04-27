package com.sharikoff977.firstProject.facades.dto.scheduleSchoolClass;

import com.sharikoff977.firstProject.model.enumeration.LessonEnum;
import lombok.Data;

import java.time.LocalTime;

@Data
public class LessonDTO {

    private LocalTime time;
    private String subjectTitle;
    private String teacherName;
    private Integer roomNumber;

}
