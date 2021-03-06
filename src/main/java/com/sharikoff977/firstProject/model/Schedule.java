package com.sharikoff977.firstProject.model;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

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

    @Column(name = "date")
    private ZonedDateTime date;

}
