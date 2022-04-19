package com.sharikoff977.firstProject.facades.dto.schoolBook;

import com.sharikoff977.firstProject.facades.dto.ScheduleDTO;
import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;
@Data
public class SbSubjectDTO {

    private SubjectDTO subject;
    private List<ZonedDateTime> schedules;
    private List<SbStudentGradeDTO> studentGrades;

}
