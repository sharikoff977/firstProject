package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.facades.dto.SchoolBookScheduleDTO;
import com.sharikoff977.firstProject.service.impl.SchoolBookScheduleServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SchoolBookScheduleController {

    private final SchoolBookScheduleServiceImpl schoolBookScheduleService;

    @GetMapping("/book-schedule-class")
    public ResponseEntity<List<SchoolBookScheduleDTO>> create(@RequestParam(name = "clazz", required = false) String clazz,
                                                        @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime date){

        List<SchoolBookScheduleDTO> result = new ArrayList<>();
        result = schoolBookScheduleService.create(clazz, date);
        return ResponseEntity.ok().body(result);

    }

}
