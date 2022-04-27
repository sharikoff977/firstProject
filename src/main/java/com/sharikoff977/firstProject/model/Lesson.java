package com.sharikoff977.firstProject.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "time_of_lesson")
    private LocalTime timeOfLesson;

}
