package com.sharikoff977.firstProject.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/*
Class Student
 */
@Entity
@Table(name = "student")
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // student id

    private String firstName; // student's name

    private String lastName; // student's last name
    @Column(name = "school_class_id")
    private Long schoolClassId;
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn()
    //private SchoolClass schoolClass; // student's school class

    /*JoinColumn
    private Set<Grade> grades;*/

    /*public Student(String firstName, String lastName*//*, SchoolClass schoolClass*//*) {
        this.firstName = firstName;
        this.lastName = lastName;
        //this.schoolClass = schoolClass;
    }

    public Student() {

    }*/
}
