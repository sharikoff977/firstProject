package com.sharikoff977.firstProject.facades.impl;

import com.sharikoff977.firstProject.facades.StudentFacade;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.model.Student;
import com.sharikoff977.firstProject.repo.StudentRepo;
import com.sharikoff977.firstProject.service.StudentService;
import com.sharikoff977.firstProject.service.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Facade implementation for managing {@link com.sharikoff977.firstProject.model.Student}
 * */
@Component
@RequiredArgsConstructor
@Slf4j
public class StudentFacadeImpl implements StudentFacade {

    private final StudentMapper studentMapper;
    private final StudentService studentService;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save Student : ", studentDTO);
        Student student = studentMapper.toEntity(studentDTO);
        student = studentService.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public List<StudentDTO> findAll() {
        log.debug("Request to find all students");
        List<StudentDTO> list = new ArrayList<>();
        for (Student student : studentService.findAll()) {
            StudentDTO studentDTO = studentMapper.toDto(student);
            list.add(studentDTO);
        }
        return list;
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        log.debug("Request to get Student : {}", id);
        Student student = studentService.findOne(id).get();
        StudentDTO studentDTO = studentMapper.toDto(student);
        return Optional.of(studentDTO);
        //return studentService.findOne(id).map(studentMapper::toDto);
    }

    /*@Override
    public List<StudentDTO> findAllBySchoolClassId(Long id) {
        log.debug("Request to find all students by school class id : {}", id);
        return studentService.findBySchoolClass(id).stream().map(studentMapper::toDto).collect(Collectors.toList());
    }*/

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Student : {}", id);
        studentService.delete(id);
    }
}
