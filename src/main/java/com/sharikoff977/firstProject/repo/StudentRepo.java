package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the StudentRepo entity.
 */

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
