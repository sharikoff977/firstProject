package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Grade;
import com.sharikoff977.firstProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Long> {
    List<Grade> findAllByStudent(Student student);
    //List<Grade> getAllByStudent(Student student);
}
