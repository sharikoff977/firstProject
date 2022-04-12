package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.facades.dto.GradeDTO;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SbStudentGradeDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SbSubjectDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SchoolBookDTO;
import com.sharikoff977.firstProject.model.Grade;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.model.Subject;
import com.sharikoff977.firstProject.repo.GradeRepo;
import com.sharikoff977.firstProject.repo.SchoolClassRepo;
import com.sharikoff977.firstProject.repo.StudentRepo;
import com.sharikoff977.firstProject.model.Student;
import com.sharikoff977.firstProject.repo.SubjectRepo;
import com.sharikoff977.firstProject.service.SchoolBookService;
import com.sharikoff977.firstProject.service.mapper.GradeMapper;
import com.sharikoff977.firstProject.service.mapper.SchoolClassMapper;
import com.sharikoff977.firstProject.service.mapper.StudentMapper;
import com.sharikoff977.firstProject.service.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        schoolBookDTO.setSchoolClassDTO(schoolClassMapper.toDTO(schoolClass));
        List<SbSubjectDTO> sbSubjectDTOList = new ArrayList<>();

        Map<Long, SbSubjectDTO> sbSubjectDTOSbStudentGradeDTOMap = new HashMap<>();

        for(Student student : schoolClass.getStudents()){
            StudentDTO studentDTO = studentMapper.toDto(student);
            SbStudentGradeDTO sbStudentGradeDTO = new SbStudentGradeDTO();
            sbStudentGradeDTO.setStudentDTO(studentDTO);

            for (Grade grade : gradeRepo.findAllByStudent(student)) {
                SbSubjectDTO sbSubjectDTO = sbSubjectDTOSbStudentGradeDTOMap.get(grade.getSubject().getId());
                if (sbSubjectDTO == null) {
                    sbSubjectDTO = new SbSubjectDTO();
                    sbSubjectDTO.setSubjectDTO(subjectMapper.toDto(grade.getSubject()));

                    List<SbStudentGradeDTO> sbStudentGradeDTOList = new ArrayList<>();
                    sbSubjectDTO.setSbStudentGradeDTOs(sbStudentGradeDTOList);


                    List<GradeDTO> gradeDTOList = new ArrayList<>();
                    sbStudentGradeDTO.setGradeDTOs(gradeDTOList);

                    sbStudentGradeDTOList.add(sbStudentGradeDTO);
                }


                sbStudentGradeDTOList.get().add(gradeMapper.toDTO(grade));


                List<SbSubjectDTO> sbSubjectDTOList = schoolBookDTO.getSbSubjectDTOs();

                if (!schoolBookDTO.getSbSubjectDTOs().contains(subjectDTO)){

                    SbSubjectDTO sbSubjectDTO = new SbSubjectDTO();
                    sbSubjectDTO.setSubjectDTO(subjectDTO);

                    List<SbStudentGradeDTO> sbStudentGradeDTOList = new ArrayList<>();
                    sbSubjectDTO.setSbStudentGradeDTOs(sbStudentGradeDTOList);

                    schoolBookDTO.getSbSubjectDTOs().add(sbSubjectDTO);
                }

                List<SbSubjectDTO> sbSubjectDTOList1  = schoolBookDTO.getSbSubjectDTOs();
                List<SbStudentGradeDTO> sbStudentGradeDTOList = sbSubjectDTOList1.get()
            }

        }

        //Create SchoolBookDTO {SchoolClassDTO, List<SbSubjectDTO>}
        /*SchoolClass schoolClass = schoolClassRepo.findByName(className);

        Set<Student> students = schoolClass.getStudents();
        List<Grade> grades = new ArrayList<>();
        Set<Subject> subjects = new HashSet<>();

        for (Student student : students){
            List<Grade> grades1 = gradeRepo.findAllByStudent(student);
            for (Grade grade : grades1){
                subjects.add(grade.getSubject());
            }
            grades.addAll(grades1);
        }

        SchoolBookDTO schoolBookDTO = new SchoolBookDTO();
        schoolBookDTO.setSchoolClassDTO(schoolClassMapper.toDTO(schoolClass));
        List<SbSubjectDTO> sbSubjectDTOS = new ArrayList<>();

        for (Subject st : subjects) {
            //Create SbSubjectDTO {SubjectDTO, List<SbStudentGradeDTO>}
            SbSubjectDTO sbSubjectDTO = new SbSubjectDTO();
            sbSubjectDTO.setSubjectDTO(subjectMapper.toDto(st));
            List<SbStudentGradeDTO> sbStudentGradeDTOs = new ArrayList<>();
            for (Student s : students) {
                //Create SbStudentGradeDTO {StudentDTO, List<GradeDTO>}
                SbStudentGradeDTO sbStudentGradeDTO = new SbStudentGradeDTO();
                sbStudentGradeDTO.setStudentDTO(studentMapper.toDto(s));
                List<GradeDTO> gradesDTOs = new ArrayList<>();
                for (Grade g : grades) {
                    if(g.getStudent().equals(s) && g.getSubject().equals(st)){
                        gradesDTOs.add(gradeMapper.toDTO(g));
                    }
                }
                sbStudentGradeDTO.setGradeDTOs(gradesDTOs);
                sbStudentGradeDTOs.add(sbStudentGradeDTO);
            }
            sbSubjectDTO.setSbStudentGradeDTOs(sbStudentGradeDTOs);
            sbSubjectDTOS.add(sbSubjectDTO);
        }
        schoolBookDTO.setSbSubjectDTOs(sbSubjectDTOS);
        return schoolBookDTO;*/
    }
}
