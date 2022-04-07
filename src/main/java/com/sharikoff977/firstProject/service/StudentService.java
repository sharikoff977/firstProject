package com.sharikoff977.firstProject.service;

import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing {@link com.sharikoff977.firstProject.model.Student}*/

public interface StudentService {
    /**
     * Save a student.
     *
     * @param student the entity to save.
     * @return the persisted entity.
     * */
    Student save(Student student);

    /**
     * Get all the students.
     *
     * @return the list of entities.
     * */
    List<Student> findAll();

    /**
     * Get the "id" student.
     *
     * @param id the id of the entity.
     * @return the entity.
     * */
    Optional<Student> findOne(Long id);

    List<StudentDTO> findBySchoolClass(Long id);

    /**
     * Delete "id" student.
     *
     * @param id the id of the entity.
     * */
    void delete(Long id);
}
