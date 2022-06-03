package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Long> {

}
