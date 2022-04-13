package com.sharikoff977.firstProject.facades.dto;

import lombok.Data;

/**
 * A DTO for the {@link com.sharikoff977.firstProject.model.Student} entity
 * */
@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long schoolClassId;
    //private Integer schoolClassNumber;
    //private String schoolClassLetter;
}
