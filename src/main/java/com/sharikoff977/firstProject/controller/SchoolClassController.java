package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.facades.SchoolClassFacade;
import com.sharikoff977.firstProject.facades.dto.SchoolClassDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing {@link com.sharikoff977.firstProject.model.SchoolClass}.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class SchoolClassController {

    private final SchoolClassFacade schoolClassFacade;

    /**
     * {@code POST  /schoolClasss} : Create a new schoolClass.
     *
     * @param schoolClassDTO the schoolClassDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new schoolClass, or with status {@code 400 (Bad Request)} if the schoolClass has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/school-class")
    public ResponseEntity<SchoolClassDTO> createSchoolClass(@RequestBody SchoolClassDTO schoolClassDTO) throws URISyntaxException{
        log.debug("REST request to save SchoolClass : {}", schoolClassDTO);
        if (schoolClassDTO.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        SchoolClassDTO result = schoolClassFacade.save(schoolClassDTO);
        return ResponseEntity.created(new URI("/api/schoolclass/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /school-class} : Updates an existing schoolClass.
     *
     * @param schoolClassDTO the schoolClassDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated schoolClassDTO,
     * or with status {@code 400 (Bad Request)} if the schoolClassDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the schoolClassDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/school-class")
    public ResponseEntity<SchoolClassDTO> updateSchoolClass(@RequestBody SchoolClassDTO schoolClassDTO) throws URISyntaxException{
        log.debug("REST request to update SchoolClass : {}", schoolClassDTO);
        if (schoolClassDTO.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        SchoolClassDTO result = schoolClassFacade.save(schoolClassDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /school-class} : get all the schoolClass.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of schoolClass in body.
     */
    @GetMapping("/school-class")
    public List<SchoolClassDTO> getAllSchoolClasses(){
        log.debug("REST request to get all ArticleCategories");
        return schoolClassFacade.findAll();
    }

    /**
     * {@code GET  /school-class/:id} : get the "id" schoolClass.
     *
     * @param id the id of the schoolClassDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the schoolClass,
     * or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/school-class/{id}")
    public ResponseEntity<SchoolClassDTO> getSchoolClass(@PathVariable Long id){
        log.debug("REST request to get SchoolClass : {}", id);
        return ResponseEntity.of(schoolClassFacade.findOne(id));
    }

    /**
     * {@code DELETE  /school-class/:id} : delete the "id" schoolClass.
     *
     * @param id the id of the schoolClassDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/school-class/{id}")
    public ResponseEntity<Void> deleteSchoolClass(@PathVariable Long id){
        log.debug("REST request to delete SchoolClass : {}", id);
        schoolClassFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

}
