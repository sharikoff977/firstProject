package com.sharikoff977.firstProject.facades;

import com.sharikoff977.firstProject.facades.dto.SchoolClassDTO;
import com.sharikoff977.firstProject.model.SchoolClass;

import java.util.List;
import java.util.Optional;

/**
 * Facade Interface for managing {@link com.sharikoff977.firstProject.model.SchoolClass}.
 */
public interface SchoolClassFacade {
    /**
     * Save an articleCategory.
     *
     * @param schoolClassDTO the entity to save.
     * @return the persisted entity.
     */
    SchoolClassDTO save(SchoolClassDTO schoolClassDTO);

    /**
     * Get all the schoolClasses
     *
     * @return the list of entities
     * */
    List<SchoolClassDTO> findAll();

    /**
     * Get the "id" scholClass
     *
     * @param id the id of the entity
     * @return the entity
     * */
    Optional<SchoolClassDTO> findOne(Long id);

    /**
     * Delete the "id" schoolClass.
     *
     * @param id the id of the entity.
     * */
    void delete(Long id);
}
