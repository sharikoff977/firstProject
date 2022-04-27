package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.model.Lesson;
import com.sharikoff977.firstProject.repo.LessonRepo;
import com.sharikoff977.firstProject.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepo lessonRepo;

    public List<Lesson> findAll(){
        return lessonRepo.findAll();
    }

}
