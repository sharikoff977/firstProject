package com.sharikoff977.firstProject.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.ZonedDateTime;

/*
Class Grade
 */
@Entity
@Data
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id grade
    /*@ManyToOne
    private Subject subject; // subject*/
    @ManyToOne
    private Student student; // student grade

    private int value; // value grade
    //private ZonedDateTime dateTime; // date grade
    @ManyToOne
    private SchoolBookSchedule schoolBookSchedule;

    /*public Grade(Subject subject, Student student, int value, ZonedDateTime dateTime) {
        this.subject = subject;
        this.student = student;
        this.value = value;
        this.dateTime = dateTime;
    }*/
}
