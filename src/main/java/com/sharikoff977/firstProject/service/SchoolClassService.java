package com.sharikoff977.firstProject.service;

import com.sharikoff977.firstProject.model.SchoolClass;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.sharikoff977.firstProject.model.SchoolClass}.
 */

public interface SchoolClassService {

    /**
     * Save an schoolClass.
     *
     * @param schoolClass the entity to save.
     * @return the persisted entity.
     */
    SchoolClass save(SchoolClass schoolClass);

    /**
     * Get all the schoolClasses
     *
     * @return the list of entities
     * */
    List<SchoolClass> findAll();

    /**
     * Get the "id" schoolClass
     *
     * @param id the id of the entity
     * @return the entity
     * */
    Optional<SchoolClass> findOne(Long id);

    /**
     * Delete the "id" schoolClass.
     *
     * @param id the id of the entity.
     * */
    void delete(Long id);
}
