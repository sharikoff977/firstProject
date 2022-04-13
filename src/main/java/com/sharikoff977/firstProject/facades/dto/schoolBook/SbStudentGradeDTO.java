package com.sharikoff977.firstProject.facades.dto.schoolBook;

import com.sharikoff977.firstProject.facades.dto.GradeDTO;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import lombok.Data;

import java.util.List;
@Data
public class SbStudentGradeDTO {

    private StudentDTO student;
    private List<GradeDTO> grades;
}
