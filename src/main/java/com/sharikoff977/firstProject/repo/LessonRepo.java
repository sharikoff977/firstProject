package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long> {
}
