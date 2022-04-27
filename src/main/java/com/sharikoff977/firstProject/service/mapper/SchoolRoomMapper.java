package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.SchoolRoomDTO;
import com.sharikoff977.firstProject.model.SchoolRoom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolRoomMapper {

    SchoolRoomDTO toDto(SchoolRoom schoolRoom);

    SchoolRoom toEntity(SchoolRoomDTO schoolRoomDTO);

}
