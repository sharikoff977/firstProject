package com.sharikoff977.firstProject.facades.dto.schoolBook;

import com.sharikoff977.firstProject.facades.dto.GradeDTO;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Data
public class SbStudentGradeDTO {

    private StudentDTO student;
    private Map<ZonedDateTime, Integer> grades;
}
