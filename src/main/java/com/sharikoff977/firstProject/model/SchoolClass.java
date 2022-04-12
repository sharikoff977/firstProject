package com.sharikoff977.firstProject.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class SchoolClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // school class id

    private int number; // class number

    private String letter; // class letter

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_class_id")
    //@OneToMany(mappedBy = "schoolClass")
    private Set<Student> students = new HashSet<>(); // list of student's in the class

    /*@ManyToMany
    @JoinTable(name = "school_class_subjects",
            joinColumns = @JoinColumn(name = "school_class_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subjects_id", referencedColumnName = "id"))
    private Set<Subject> subjects = new HashSet<>();*/

    /*@OneToMany
    private Set<Subject> subjects = new HashSet<>();*/
}
