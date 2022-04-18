package com.sharikoff977.firstProject.controller.advice;

import com.sharikoff977.firstProject.facades.dto.SchoolClassDTO;
import com.sharikoff977.firstProject.service.SchoolClassService;
import com.sharikoff977.firstProject.service.mapper.SchoolClassMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = Controller.class)
public class CommonModelAdvice {

    @Autowired
    private SchoolClassService schoolClassService;

    @Autowired
    private SchoolClassMapper schoolClassMapper;

    @ModelAttribute("classes")
    public List<SchoolClassDTO> schoolClasses() {
      return schoolClassMapper.toDto(schoolClassService.findAll());
    }
}
