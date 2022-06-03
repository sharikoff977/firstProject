package com.sharikoff977.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SbSubjectDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SchoolBookDTO;
import com.sharikoff977.firstProject.service.GradeService;
import com.sharikoff977.firstProject.service.SchoolBookService;
import com.sharikoff977.firstProject.service.mapper.StudentMapper;
import com.sharikoff977.firstProject.service.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SchoolBookController {

  @Autowired
  private SchoolBookService schoolBookService;

  @Autowired
  private SubjectMapper subjectMapper;

  private final StudentMapper studentMapper;

  private final GradeService gradeService;

  @GetMapping("/api/school-book")
  public SchoolBookDTO getSchoolBook(@RequestParam(name = "clazz", required = false) String clazz,
                                     @RequestParam(name = "data", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateTime) throws JsonProcessingException {
    SchoolBookDTO schoolBook = schoolBookService.getSchoolBook(clazz, dateTime);
    /*Integer maxGradesCount = schoolBook.getSubjects().stream()
        .map(SbSubjectDTO::getStudentGrades)
        .flatMap(List::stream)
        .map(SbStudentGradeDTO::getGrades)
        .map(List::size)
        .max(Integer::compareTo).orElse(0);*/
    Map<SubjectDTO, List<ZonedDateTime>> subjectSchedulesMap = new HashMap<>();
    for (SbSubjectDTO subject : schoolBook.getSubjects()){
      subjectSchedulesMap.put(subject.getSubject(), subject.getSchedules());
    }
    return schoolBook;
  }

}
