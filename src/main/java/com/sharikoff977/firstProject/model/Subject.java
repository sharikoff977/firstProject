package com.sharikoff977.firstProject.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // subject id
    private String title; // subject's title

    /*@ManyToMany
    private Set<SchoolClass> schoolClasses = new HashSet<>();*/
}
