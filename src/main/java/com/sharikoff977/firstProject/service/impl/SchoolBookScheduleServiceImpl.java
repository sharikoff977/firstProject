package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.facades.dto.ScheduleDTO;
import com.sharikoff977.firstProject.facades.dto.SchoolBookScheduleDTO;
import com.sharikoff977.firstProject.model.Schedule;
import com.sharikoff977.firstProject.model.SchoolBookSchedule;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.repo.ScheduleRepo;
import com.sharikoff977.firstProject.repo.SchoolBookScheduleRepo;
import com.sharikoff977.firstProject.repo.SchoolClassRepo;
import com.sharikoff977.firstProject.service.mapper.ScheduleMapper;
import com.sharikoff977.firstProject.service.mapper.SchoolBookScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolBookScheduleServiceImpl {

    private final SchoolBookScheduleRepo schoolBookScheduleRepo;
    private final SchoolBookScheduleMapper schoolBookScheduleMapper;
    private final SchoolClassRepo schoolClassRepo;
    private final ScheduleRepo scheduleRepo;
    private final ScheduleServiceImpl scheduleService;

    public List<SchoolBookScheduleDTO> create(String name, ZonedDateTime data){

        List<ScheduleDTO> scheduleDTOList = scheduleService.findBySchoolClassName(name);
        List<SchoolBookScheduleDTO> schoolBookScheduleDTOList = new ArrayList<>();
        for(ScheduleDTO scheduleDTO : scheduleDTOList){

            SchoolBookScheduleDTO schoolBookScheduleDTO = new SchoolBookScheduleDTO();
            schoolBookScheduleDTO.setSchoolClassId(scheduleDTO.getSchoolClassId());
            schoolBookScheduleDTO.setSubjectId(scheduleDTO.getSubjectId());
            schoolBookScheduleDTO.setTeacherId(scheduleDTO.getTeacherId());
            schoolBookScheduleDTO.setSchoolRoomId(scheduleDTO.getSchoolRoomId());
            DayOfWeek dayOfWeek = scheduleDTO.getDayOfWeek();
            schoolBookScheduleDTO.setDate(data.plusDays(dayOfWeek.getValue() - 1));
            schoolBookScheduleDTOList.add(save(schoolBookScheduleDTO));

        }

        return schoolBookScheduleDTOList;

    }

    public SchoolBookScheduleDTO save(SchoolBookScheduleDTO schoolBookScheduleDTO){
        SchoolBookSchedule schoolBookSchedule = schoolBookScheduleMapper.toEntity(schoolBookScheduleDTO);
        return schoolBookScheduleMapper.toDto(schoolBookScheduleRepo.save(schoolBookSchedule));
    }

    public List<SchoolBookScheduleDTO> findAll(){
        return schoolBookScheduleRepo.findAll().stream().map(schoolBookScheduleMapper::toDto).collect(Collectors.toList());
    }

    public Optional<SchoolBookScheduleDTO> findOne(Long id){
        return schoolBookScheduleRepo.findById(id).map(schoolBookScheduleMapper::toDto);
    }

    public void delete(Long id){
        schoolBookScheduleRepo.deleteById(id);
    }

}
