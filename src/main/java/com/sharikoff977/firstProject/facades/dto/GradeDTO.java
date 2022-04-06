package com.sharikoff977.firstProject.facades.dto;

import lombok.Data;

import java.util.Date;
@Data
public class GradeDTO {
    private Long id;
    private Long subjectId;
    private Long studentId;
    private Integer value;
    private Date dateTime;
}
