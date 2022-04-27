package com.sharikoff977.firstProject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SchoolRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number")
    private Integer number;

}
