package com.sharikoff977.firstProject.facades.dto.schoolBook;

import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import lombok.Data;

import java.util.List;
@Data
public class SbSubjectDTO {

    private SubjectDTO subjectDTO;
    private List<SbStudentGradeDTO> sbStudentGradeDTOs;

}
