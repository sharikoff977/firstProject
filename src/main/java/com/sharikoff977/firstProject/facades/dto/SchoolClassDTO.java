package com.sharikoff977.firstProject.facades.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sharikoff977.firstProject.model.SchoolClass} entity.
 */
@Data
public class SchoolClassDTO implements Serializable {
    private Long id;
    private int number;
    private char letter;
}
