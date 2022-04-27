package com.sharikoff977.firstProject.facades.dto.schoolBook;

import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Map;

@Data
public class SbStudentGradeDTO {

    private StudentDTO student;
    private Map<ZonedDateTime, SbGradeIdValueDTO> grades;
}
