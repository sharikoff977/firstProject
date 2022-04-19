package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllBySchoolClassIdAndSubjectId(Long school_class_id, Long subject_id);
    List<Schedule> findAllBySchoolClassId(Long school_class_id);
}
