package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.facades.GradeFacade;
import com.sharikoff977.firstProject.facades.dto.GradeDTO;
import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.model.Grade;
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
@Slf4j
@RequiredArgsConstructor
public class GradeController {
    private final GradeFacade gradeFacade;

    @PostMapping("/grade")
    public ResponseEntity<GradeDTO> createGrade(@RequestBody GradeDTO gradeDTO) throws URISyntaxException{
        if (gradeDTO.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        GradeDTO result = gradeFacade.save(gradeDTO);
        return ResponseEntity.created(new URI("/api/grade" + result.getId())).body(result);
    }

    @PutMapping("/grade")
    public ResponseEntity<GradeDTO> updateGrade(@RequestBody GradeDTO gradeDTO){
        if (gradeDTO.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        GradeDTO result = gradeFacade.save(gradeDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/grade")
    public ResponseEntity<List<GradeDTO>> findAllGrades(){
        List<GradeDTO> result = gradeFacade.findAll();
        return ResponseEntity.ok().header("x-total-count", String.valueOf(result.size())).body(result);
    }

    @GetMapping("/grade/{id}")
    public ResponseEntity<GradeDTO> getGrade(@PathVariable Long id){
        Optional<GradeDTO> gradeDTO = gradeFacade.findOne(id);
        return ResponseEntity.of(gradeDTO);
    }

    @DeleteMapping("/grade/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id){
        gradeFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
