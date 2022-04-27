package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.facades.dto.scheduleSchoolClass.ScheduleSchoolClassDTO;
import com.sharikoff977.firstProject.service.impl.ScheduleSchoolClassServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleSchoolClassController {

    private final ScheduleSchoolClassServiceImpl scheduleSchoolClassService;

    @GetMapping("/schedule-class/{clazz}")
    public ResponseEntity<ScheduleSchoolClassDTO> getScheduleSchoolClass(@PathVariable(name = "clazz") String clazz){
        ScheduleSchoolClassDTO scheduleSchoolClassDTO = scheduleSchoolClassService.getScheduleSchoolClass(clazz);
        return ResponseEntity.ok().body(scheduleSchoolClassDTO);
    }

}
