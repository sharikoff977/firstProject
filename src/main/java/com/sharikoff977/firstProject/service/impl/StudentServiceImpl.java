package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.model.Student;
import com.sharikoff977.firstProject.repo.StudentRepo;
import com.sharikoff977.firstProject.service.StudentService;
import com.sharikoff977.firstProject.service.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service implementation for managing {@link com.sharikoff977.firstProject.model.Student}
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    @Override
    public Student save(Student student) {
        log.debug("Request to save student : {}", student);
        return studentRepo.save(student);
    }

    @Override
    public List<Student> findAll() {
        log.debug("Request to find all students");
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> findOne(Long id) {
        log.debug("Request to get student : {}", id);
        return studentRepo.findById(id);
    }

    /*@Override
    public List<Student> findBySchoolClass(Long id) {
        log.debug("Request to find all students by school class id : {}", id);
        return studentRepo.findAllBySchoolClassId(id);
    }*/

    @Override
    public List<StudentDTO> findBySchoolClass(Long id) {
        log.debug("Request to find all student by school class id : {}", id);
        /*List<Student> students = studentRepo.findAllBySchoolClassId(id);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student s : students){
            StudentDTO studentDTO = studentMapper.toDto(s);
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;*/
        return studentRepo.findAllBySchoolClassId(id).stream()
                .map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete student : {}", id);
        studentRepo.deleteById(id);
    }
}
