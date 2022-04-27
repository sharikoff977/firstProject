package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
