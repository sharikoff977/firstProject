package com.sharikoff977.firstProject.service.mapper;

import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.model.Subject;
import com.sharikoff977.firstProject.repo.SubjectRepo;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper (componentModel = "spring")
public abstract class SubjectMapper {

    @Autowired
    public SubjectRepo subjectRepo;

    public abstract SubjectDTO toDto(Subject subject);

    public abstract Subject toEntity(SubjectDTO subjectDTO);

    public Subject fromId(Long id){
        return subjectRepo.getById(id);
    }

    /*default Subject fromId(Long id) {
        if (id == null) {
            return null;
        }
        Subject subject = new Subject();
        subject.setId(id);
        return subject;
    }*/
}
