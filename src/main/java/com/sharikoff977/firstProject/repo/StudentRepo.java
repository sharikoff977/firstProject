package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
