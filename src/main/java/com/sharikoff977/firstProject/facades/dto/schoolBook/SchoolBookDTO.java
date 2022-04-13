package com.sharikoff977.firstProject.facades.dto.schoolBook;

import com.sharikoff977.firstProject.facades.dto.SchoolClassDTO;
import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import com.sharikoff977.firstProject.model.SchoolClass;
import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
public class SchoolBookDTO {

    private SchoolClassDTO schoolClass;
    private List<SbSubjectDTO> subjects;

}
