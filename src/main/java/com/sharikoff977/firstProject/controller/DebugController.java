package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.facades.dto.LessonDTO;
import com.sharikoff977.firstProject.model.SchoolBookSchedule;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.repo.GradeRepo;
import com.sharikoff977.firstProject.repo.SchoolBookScheduleRepo;
import com.sharikoff977.firstProject.repo.SchoolClassRepo;
import com.sharikoff977.firstProject.service.impl.LessonServiceImpl;
import com.sharikoff977.firstProject.service.impl.SchoolBookServiceImpl;
import com.sharikoff977.firstProject.service.mapper.LessonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/debug")
@RequiredArgsConstructor
public class DebugController {
    private final SchoolClassRepo schoolClassRepo;
    private final GradeRepo gradeRepo;
    private final SchoolBookServiceImpl schoolBookServiceImpl;
    private final LessonServiceImpl lessonServiceImpl;
    private final LessonMapper lessonMapper;
    private final SchoolBookScheduleRepo schoolBookScheduleRepo;

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<SchoolClass> getSchoolClassByName(@PathVariable String name){
        return ResponseEntity.ok(schoolClassRepo.findByName(name));
    }

    /*@GetMapping("/school-book/{name}")
    public ResponseEntity<SchoolBookDTO> getSchoolBookByClassName(@PathVariable String name){
        return ResponseEntity.ok().body(schoolBookServiceImpl.getSchoolBook(name));
    }*/

    @GetMapping("/schedule")
    public ResponseEntity<List<LessonDTO>> getSchedule(){
        return ResponseEntity.ok().body(lessonServiceImpl.findAll().stream().map(lessonMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/school-book-schedule")
    public ResponseEntity<List<SchoolBookSchedule>> getAllBySchoolClassIdAndDate(@RequestParam(name = "classId", required = false) Long id,
                                                                                  @RequestParam(name = "dateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateTime){
        return ResponseEntity.ok(schoolBookScheduleRepo.findAllBySchoolClassIdAndDate(id, dateTime));
    }

}
