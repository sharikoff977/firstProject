package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.facades.StudentFacade;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.model.Student;
import com.sharikoff977.firstProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 *Rest controller for managing {@link com.sharikoff977.firstProject.model.Student}
 * */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentFacade studentFacade;
    private final StudentService studentService;

    /**
     *{@code POST /student} : Create a new student.
     *
     * @param studentDTO the studentDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)}and with body the new studentDTO,
     * or with status {@code 400 (Bad request)} if the student has already the Id.
     * @throws URISyntaxException if the location URI syntax is incorrect.
     * */
    @PostMapping("/student")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) throws URISyntaxException{
        log.debug("Request to save Student : {}", studentDTO);
        if (studentDTO.getId() != null){
            ResponseEntity.badRequest().build();
        }
        StudentDTO result = studentFacade.save(studentDTO);
        return ResponseEntity.created(new URI("/api/student/" + result.getId())).body(result);
    }

    /**
     * {@code PUT /student} : Update the existing student.
     *
     * @param studentDTO the studentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (Ok)} and with body the update studentDTO,
     * <br/>
     * {@code 400 (Bad Request)} if the studentDTO is not valid,
     * <br/>
     * {@code 500 (Internal Server Error)} if the studentDTO couldn't be updated.
     * @throws URISyntaxException if the location URI syntax is incorrect.
     * */
    @PutMapping("/student")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) throws URISyntaxException{
        log.debug("Request to update Student : {}", studentDTO);
        if (studentDTO.getId() == null){
            ResponseEntity.badRequest().build();
        }
        StudentDTO result = studentFacade.save(studentDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET /student} get all the students.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} with the list of the students in body.
     * */
    @GetMapping("/student")
    public ResponseEntity<List<StudentDTO>> findAllStudents(){
        log.debug("Request to get all students");
        List<StudentDTO> result = studentFacade.findAll();
        return ResponseEntity.ok().header("x-total-count", String.valueOf(result.size())).body(result);
    }

    /**
     * {@code GET /student/{id}} get the "id" student.
     *
     * @param id the id of the studentDTO to retrieve.
     * @return the {@link ResponseEntity} whith status {@code 200 (OK)} and with body the studentDTO,
     * or with status {@code 404 (NOT FOUND)}.
     * */
    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
        log.debug("REST Request to get Student : {}", id);
        Optional<StudentDTO> studentDTO = studentFacade.findOne(id);
        return ResponseEntity.of(studentDTO);
    }

    @GetMapping("/student-by-shcool-class-id/{id}")
    public ResponseEntity<List<StudentDTO>> findAllStudentsBySchoolClassId(@PathVariable Long id){
        log.debug("REST Request to find all student by school class id : {}", id);
        List<StudentDTO> result = studentService.findBySchoolClass(id);
        return ResponseEntity.ok().header("x-total-count", String.valueOf(result.size())).body(result);
    }

    /**
     * {@code DELETE /student/{id}} delete the "id" student.
     *
     * @param id the id of the studentDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     * */
    @DeleteMapping("/student/{id}")
    public  ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        log.debug("REST Request to delete student : {}", id);
        studentFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
