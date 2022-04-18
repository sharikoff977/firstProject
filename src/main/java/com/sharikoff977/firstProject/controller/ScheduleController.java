package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.facades.dto.ScheduleDTO;
import com.sharikoff977.firstProject.model.Schedule;
import com.sharikoff977.firstProject.service.ScheduleService;
import com.sharikoff977.firstProject.service.mapper.ScheduleMapper;
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
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleMapper scheduleMapper;

    @PostMapping("/schedule")
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) throws URISyntaxException {
        if (scheduleDTO.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        ScheduleDTO result = scheduleService.save(scheduleDTO);
        return ResponseEntity.created(new URI("/api/schedule" + result.getId())).body(result);
    }

    @PutMapping("/schedule")
    public ResponseEntity<ScheduleDTO> updateSchedule(@RequestBody ScheduleDTO scheduleDTO){
        if (scheduleDTO.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        ScheduleDTO result = scheduleService.save(scheduleDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleDTO>> findAllSchedules(){
        List<ScheduleDTO> result = scheduleService.findAll();
        return ResponseEntity.ok().header("x-total-count", String.valueOf(result.size())).body(result);
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<ScheduleDTO> getSchedule(@PathVariable Long id){
        Optional<ScheduleDTO> scheduleDTO = scheduleService.findOne(id);
        return ResponseEntity.of(scheduleDTO);
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        scheduleService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
