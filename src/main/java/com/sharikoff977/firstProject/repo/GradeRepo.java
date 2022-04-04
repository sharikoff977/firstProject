package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepo extends JpaRepository<Grade, Long> {
}
