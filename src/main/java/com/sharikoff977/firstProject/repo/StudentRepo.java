package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data repository for the StudentRepo entity.
 */

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findAllBySchoolClassId(Long id);
}
