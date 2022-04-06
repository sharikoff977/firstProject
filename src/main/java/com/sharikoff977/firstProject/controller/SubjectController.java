package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.facades.StudentFacade;
import com.sharikoff977.firstProject.facades.SubjectFacade;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import com.sharikoff977.firstProject.model.Subject;
//import jdk.internal.org.objectweb.asm.tree.VarInsnNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class SubjectController {

    private final SubjectFacade subjectFacade;

    @PostMapping("/subject")
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO subjectDTO) throws URISyntaxException {
        log.debug("REST Request to save Subject : {}", subjectDTO);
        if (subjectDTO.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        SubjectDTO result = subjectFacade.save(subjectDTO);
        return ResponseEntity.created(new URI("/api/subject" + result.getId())).body(result);
    }

    @PutMapping("/subject")
    public ResponseEntity<SubjectDTO> updateSubject(@RequestBody SubjectDTO subjectDTO){
        log.debug("REST Request to update Subject : {}", subjectDTO);
        if (subjectDTO.getId() == null){
            return  ResponseEntity.badRequest().build();
        }
        SubjectDTO result = subjectFacade.save(subjectDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/subject")
    public ResponseEntity<List<SubjectDTO>> findAllSubjects(){
        log.debug("REST Request to find all subjects");
        List<SubjectDTO> subjectDTOList = subjectFacade.findAll();
        return ResponseEntity.ok().header("x-total-count", String.valueOf(subjectDTOList.size())).body(subjectDTOList);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<SubjectDTO> findSubject(@PathVariable Long id){
        log.debug("REST Request to find subject by id : {}", id);
        Optional<SubjectDTO> result = subjectFacade.findOne(id);
        return ResponseEntity.of(result);
    }

    @DeleteMapping("/subject/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id){
        log.debug("REST Request to delete subject by id : {}", id);
        subjectFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

}
