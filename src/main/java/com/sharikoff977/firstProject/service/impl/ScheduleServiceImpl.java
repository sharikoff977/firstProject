package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.facades.dto.ScheduleDTO;
import com.sharikoff977.firstProject.model.Schedule;
import com.sharikoff977.firstProject.repo.ScheduleRepo;
import com.sharikoff977.firstProject.service.ScheduleService;
import com.sharikoff977.firstProject.service.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepo scheduleRepo;
    private final ScheduleMapper scheduleMapper;

    public ScheduleDTO save(ScheduleDTO scheduleDTO){
        Schedule schedule = scheduleMapper.toEntity(scheduleDTO);
        return scheduleMapper.toDto(scheduleRepo.save(schedule));
    }

    public List<ScheduleDTO> findAll(){
        return scheduleRepo.findAll().stream().map(scheduleMapper::toDto).collect(Collectors.toList());
    }

    public Optional<ScheduleDTO> findOne(Long id){
        return scheduleRepo.findById(id).map(scheduleMapper::toDto);
    }

    public void delete(Long id){
        scheduleRepo.deleteById(id);
    }

}
