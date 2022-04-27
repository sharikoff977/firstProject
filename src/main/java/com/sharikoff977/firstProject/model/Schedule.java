package com.sharikoff977.firstProject.model;

import lombok.Data;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;

import static java.time.DayOfWeek.MONDAY;

@Entity
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "school_class_id")
    private Long schoolClassId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "school_room_id")
    private Long schoolRoomId;

    @Column(name = "date")
    private ZonedDateTime date;

    @Column(name = "day_of_week")
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @OneToOne
    private Lesson lesson;

}
