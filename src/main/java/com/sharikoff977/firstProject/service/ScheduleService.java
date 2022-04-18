package com.sharikoff977.firstProject.service;

import com.sharikoff977.firstProject.facades.dto.ScheduleDTO;
import com.sharikoff977.firstProject.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {

     ScheduleDTO save(ScheduleDTO scheduleDTO);

     List<ScheduleDTO> findAll();

     Optional<ScheduleDTO> findOne(Long id);

     void delete(Long id);

}
