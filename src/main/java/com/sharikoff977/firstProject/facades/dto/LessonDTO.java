package com.sharikoff977.firstProject.facades.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class LessonDTO {

    private Long id;
    private Integer number;
    private LocalTime timeOfLesson;

}
