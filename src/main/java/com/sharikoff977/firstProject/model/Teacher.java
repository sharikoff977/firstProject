package com.sharikoff977.firstProject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
}
