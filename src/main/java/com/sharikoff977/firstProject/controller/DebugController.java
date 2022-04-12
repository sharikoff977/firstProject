package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.facades.dto.StudentDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SchoolBookDTO;
import com.sharikoff977.firstProject.model.Grade;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.model.Student;
import com.sharikoff977.firstProject.repo.GradeRepo;
import com.sharikoff977.firstProject.repo.SchoolClassRepo;
import com.sharikoff977.firstProject.service.impl.SchoolBookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/debug")
@RequiredArgsConstructor
public class DebugController {
    private final SchoolClassRepo schoolClassRepo;
    private final GradeRepo gradeRepo;
    private final SchoolBookServiceImpl schoolBookServiceImpl;

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<SchoolClass> getSchoolClassByName(@PathVariable String name){
        return ResponseEntity.ok(schoolClassRepo.findByName(name));
    }

    @GetMapping("/school-book/{name}")
    public ResponseEntity<SchoolBookDTO> getSchoolBookByClassName(@PathVariable String name){
        return ResponseEntity.ok().body(schoolBookServiceImpl.getSchoolBook(name));
    }
}
