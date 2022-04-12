package com.sharikoff977.firstProject.facades.dto.schoolBook;

import com.sharikoff977.firstProject.facades.dto.GradeDTO;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import lombok.Data;

import java.util.List;
@Data
public class SbStudentGradeDTO {

    private StudentDTO studentDTO;
    private List<GradeDTO> gradeDTOs;

}
