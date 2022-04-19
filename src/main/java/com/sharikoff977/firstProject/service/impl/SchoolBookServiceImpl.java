package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.facades.dto.ScheduleDTO;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SbStudentGradeDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SbSubjectDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SchoolBookDTO;
import com.sharikoff977.firstProject.model.*;
import com.sharikoff977.firstProject.repo.GradeRepo;
import com.sharikoff977.firstProject.repo.ScheduleRepo;
import com.sharikoff977.firstProject.repo.SchoolClassRepo;
import com.sharikoff977.firstProject.repo.SubjectRepo;
import com.sharikoff977.firstProject.service.SchoolBookService;
import com.sharikoff977.firstProject.service.mapper.*;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
    private final ScheduleRepo scheduleRepo;
    private final ScheduleMapper scheduleMapper;

    public SchoolBookDTO getSchoolBook(String className) {
        /*SchoolClass schoolClass = schoolClassRepo.findByName(className); // Поиск нужного класса

        SchoolBookDTO schoolBookDTO = new SchoolBookDTO(); // Создание классного журнала
        schoolBookDTO.setSchoolClass(schoolClassMapper.toDto(schoolClass)); // Наполнение данными журнал
        schoolBookDTO.setSubjects(new ArrayList<>());

        Map<Long, SbSubjectDTO> subjectMap = new HashMap<>();

        for (Student student : schoolClass.getStudents()) { // Перебор учеников в классе

            StudentDTO studentDTO = studentMapper.toDto(student);

            Map<Subject, SbStudentGradeDTO>  subjectGradeMap = new HashMap<>();

            for (Grade grade : gradeRepo.findAllByStudent(student)) { // Перебор оценок ученика в классе

               SbStudentGradeDTO studentGrades = subjectGradeMap.get(grade.getSubject());
               // Оценки этого студента по текущему предмету
               if (studentGrades == null) {
                   // По этому предмету у студента еще нет оценок,
                   studentGrades = new SbStudentGradeDTO();
                   studentGrades.setStudent(studentDTO);
                   studentGrades.setGrades(new ArrayList<>());
                   subjectGradeMap.put(grade.getSubject(), studentGrades);

                   SbSubjectDTO subjectDTO = subjectMap.get(grade.getSubject().getId());
                   // Уже могут быть оценки по предмету у других студентов
                   if (subjectDTO == null) {
                       // Такой предмет еще не попадался, нужно создать страницу в журнале
                       subjectDTO = new SbSubjectDTO();
                       subjectDTO.setSubject(subjectMapper.toDto(grade.getSubject()));
                       subjectDTO.setStudentGrades(new ArrayList<>());
                       subjectMap.put(grade.getSubject().getId(), subjectDTO);
                       // это только для быстрого поиска
                       // добавляем предмет в журнал
                       schoolBookDTO.getSubjects().add(subjectDTO);
                   }
                   subjectDTO.getStudentGrades().add(studentGrades);
               }
               studentGrades.getGrades().add(gradeMapper.toDTO(grade));
            }
        }
        return schoolBookDTO;*/

        SchoolClass schoolClass = schoolClassRepo.findByName(className);

        SchoolBookDTO schoolBookDTO = new SchoolBookDTO();
        schoolBookDTO.setSchoolClass(schoolClassMapper.toDto(schoolClass));
        schoolBookDTO.setSubjects(new ArrayList<>());

        List<Schedule> schedules = scheduleRepo.findAllBySchoolClassId(schoolClass.getId());
        /*Map<Long, Map<ZonedDateTime, Integer>> subjectMapMap = new HashMap<>();
        for (Schedule schedule : schedules){
            Map<ZonedDateTime, Integer> zonedDateTimeIntegerMap = subjectMapMap.get(schedule.getSubjectId());
            if (zonedDateTimeIntegerMap == null){
                zonedDateTimeIntegerMap = new HashMap<>();
                subjectMapMap.put(schedule.getSubjectId(), zonedDateTimeIntegerMap);
            }
            zonedDateTimeIntegerMap.put(schedule.getDate(), null);
        }*/

        Map<Long, SbSubjectDTO> subjectMap = new HashMap<>();

        for(Student student : schoolClass.getStudents()){

            StudentDTO studentDTO = studentMapper.toDto(student);

            Map<Subject, SbStudentGradeDTO> subjectGradeMap = new HashMap<>();

            for (Grade grade : gradeRepo.findAllByStudent(student)){

                SbStudentGradeDTO studentGrades = subjectGradeMap.get(grade.getSubject());
                if (studentGrades == null){

                    studentGrades = new SbStudentGradeDTO();
                    studentGrades.setStudent(studentDTO);
                    //Map<ZonedDateTime, Integer> scheduleGrades = subjectMapMap.get(grade.getSubject().getId());
                    studentGrades.setGrades(new HashMap<>(/*scheduleGrades*/));

                    subjectGradeMap.put(grade.getSubject(), studentGrades);

                    SbSubjectDTO subjectDTO = subjectMap.get(grade.getSubject().getId());
                    if (subjectDTO == null){
                        subjectDTO = new SbSubjectDTO();
                        subjectDTO.setSubject(subjectMapper.toDto(grade.getSubject()));
                        subjectDTO.setStudentGrades(new ArrayList<>());
                        subjectMap.put(grade.getSubject().getId(), subjectDTO);
                        schoolBookDTO.getSubjects().add(subjectDTO);
                        subjectDTO.setSchedules(scheduleRepo.findAllBySchoolClassIdAndSubjectId(schoolClass.getId(),
                                subjectDTO.getSubject().getId())
                                .stream().map(Schedule::getDate).collect(Collectors.toList()));
                    }
                    subjectDTO.getStudentGrades().add(studentGrades);
                }
                studentGrades.getGrades().put(grade.getDateTime(), grade.getValue());
            }

        }
        return  schoolBookDTO;
    }
}
