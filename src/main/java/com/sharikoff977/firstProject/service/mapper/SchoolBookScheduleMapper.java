package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.SchoolBookScheduleDTO;
import com.sharikoff977.firstProject.model.SchoolBookSchedule;
import com.sharikoff977.firstProject.repo.SchoolBookScheduleRepo;
import org.hibernate.action.internal.EntityAction;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SchoolBookScheduleMapper implements EntityMapper<SchoolBookScheduleDTO, SchoolBookSchedule> {

    @Autowired
    private SchoolBookScheduleRepo schoolBookScheduleRepo;

    public abstract SchoolBookScheduleDTO toDto(SchoolBookSchedule schoolBookSchedule);

    public abstract SchoolBookSchedule toEntity(SchoolBookScheduleDTO schoolBookScheduleDTO);

    public SchoolBookSchedule fromId(Long id){ return schoolBookScheduleRepo.getById(id); }

}
