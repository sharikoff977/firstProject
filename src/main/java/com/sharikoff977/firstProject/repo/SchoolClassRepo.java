package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data repository for the SchoolClassRepo entity.
 */

public interface SchoolClassRepo extends JpaRepository<SchoolClass, Long> {
}
