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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // school class id

    private int number; // class number

    private char letter; // class letter

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_class_id")
    //@OneToMany(mappedBy = "school_class_id")
    private Set<Student> students = new HashSet<>(); // list of student's in the class

    /*public SchoolClass(int number, char letter) {
        this.number = number;
        this.letter = letter;
    }

    public SchoolClass() {

    }*/
}
