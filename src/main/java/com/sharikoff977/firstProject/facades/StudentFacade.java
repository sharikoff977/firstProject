package com.sharikoff977.firstProject.facades;

import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.model.Student;

import java.util.List;
import java.util.Optional;
/**
 *
 * */
public interface StudentFacade {
    /**
     * Save a student.
     *
     * @param studentDTO the entity to save.
     * @return the persisted entity.
     * */
    StudentDTO save(StudentDTO studentDTO);

    /**
     * Get all the students.
     *
     * @return the list of entities.
     * */
    List<StudentDTO> findAll();

    /**
     * Get the "id" student.
     *
     * @param id the id of the entity.
     * @return the entity.
     * */
    Optional<StudentDTO> findOne(Long id);

    /*List<StudentDTO> findAllBySchoolClassId(Long id);*/

    /**
     * Delete "id" student.
     *
     * @param id the id of the entity.
     * */
    void delete(Long id);

}
