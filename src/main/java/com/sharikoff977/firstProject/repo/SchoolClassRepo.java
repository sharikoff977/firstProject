package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the SchoolClassRepo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SchoolClassRepo extends JpaRepository<SchoolClass, Long> {
}
