package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SbStudentGradeDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SbSubjectDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SchoolBookDTO;
import com.sharikoff977.firstProject.model.Grade;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.model.Subject;
import com.sharikoff977.firstProject.repo.GradeRepo;
import com.sharikoff977.firstProject.repo.SchoolClassRepo;
import com.sharikoff977.firstProject.model.Student;
import com.sharikoff977.firstProject.repo.SubjectRepo;
import com.sharikoff977.firstProject.service.SchoolBookService;
import com.sharikoff977.firstProject.service.mapper.GradeMapper;
import com.sharikoff977.firstProject.service.mapper.SchoolClassMapper;
import com.sharikoff977.firstProject.service.mapper.StudentMapper;
import com.sharikoff977.firstProject.service.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolBookServiceImpl implements SchoolBookService {

    private final SchoolClassRepo schoolClassRepo;
    private final GradeRepo gradeRepo;
    private final SchoolClassMapper schoolClassMapper;
    private final StudentMapper studentMapper;
    private final GradeMapper gradeMapper;
    private final SubjectMapper subjectMapper;
    private final SubjectRepo subjectRepo;

    public SchoolBookDTO getSchoolBook(String className) {
        SchoolClass schoolClass = schoolClassRepo.findByName(className);

        SchoolBookDTO schoolBookDTO = new SchoolBookDTO();
        schoolBookDTO.setSchoolClass(schoolClassMapper.toDto(schoolClass));
        schoolBookDTO.setSubjects(new ArrayList<>());

        Map<Long, SbSubjectDTO> subjectMap = new HashMap<>();

        for (Student student : schoolClass.getStudents()) {
            StudentDTO studentDTO = studentMapper.toDto(student);
            Map<Subject, SbStudentGradeDTO>  subjectGradeMap = new HashMap<>();
            for (Grade grade : gradeRepo.findAllByStudent(student)) {
               SbStudentGradeDTO studentGrades = subjectGradeMap.get(grade.getSubject()); // Оценки этого студента по текущему предмету
               if (studentGrades == null) {
                   // По этому предмету у студента еще нет оценок,
                   studentGrades = new SbStudentGradeDTO();
                   studentGrades.setStudent(studentDTO);
                   studentGrades.setGrades(new ArrayList<>());
                   subjectGradeMap.put(grade.getSubject(), studentGrades);

                   SbSubjectDTO subjectDTO = subjectMap.get(grade.getSubject().getId()); // Уже могут быть оценки по предмету у других студентов
                   if (subjectDTO == null) {
                       // Такой предмет еще не попадался, нужно создать страницу в журнале
                       subjectDTO = new SbSubjectDTO();
                       subjectDTO.setSubject(subjectMapper.toDto(grade.getSubject()));
                       subjectDTO.setStudentGrades(new ArrayList<>());
                       subjectMap.put(grade.getSubject().getId(), subjectDTO);// это только для быстрого поиска
                       // добавляем предмет в журнал
                       schoolBookDTO.getSubjects().add(subjectDTO);
                   }
                   subjectDTO.getStudentGrades().add(studentGrades);
               }
               studentGrades.getGrades().add(gradeMapper.toDTO(grade));
            }
        }
        return schoolBookDTO;
    }
}
