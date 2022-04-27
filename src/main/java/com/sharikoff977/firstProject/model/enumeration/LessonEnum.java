package com.sharikoff977.firstProject.model.enumeration;

import java.time.Clock;
import java.time.LocalTime;

public enum LessonEnum {

    FIRST(1, LocalTime.of(8,0)),
    SECOND(2,LocalTime.of(9,0)),
    THIRD(3, LocalTime.of(10,0)),
    FOURTH(4, LocalTime.of(11,0)),
    FIFTH(5, LocalTime.of(12,0)),
    SIXTH(6, LocalTime.of(13,0));

    private Integer num;
    private LocalTime lesson;

    LessonEnum(Integer num, LocalTime lesson) {
        this.num = num;
        this.lesson = lesson;
    }

    public Integer getNum() {
        return num;
    }

    public LocalTime getLesson() {
        return lesson;
    }
}
