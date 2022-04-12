package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the SchoolClassRepo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SchoolClassRepo extends JpaRepository<SchoolClass, Long> {
    @Query("from SchoolClass where concat(number, letter) = :className")
    SchoolClass findByName(@Param("className") String name);
}
