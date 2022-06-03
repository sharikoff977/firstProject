package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.SchoolBookSchedule;
import lombok.experimental.PackagePrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface SchoolBookScheduleRepo extends JpaRepository<SchoolBookSchedule, Long> {

    @Query("from SchoolBookSchedule where schoolClassId = :schoolClassId and date >= :dateTime ")
    List<SchoolBookSchedule> findAllBySchoolClassIDAndDate(@Param("schoolClassId") Long id,
                                                           @Param("dateTime") ZonedDateTime date);

    @Query("from SchoolBookSchedule where schoolClassId = :schoolClassId " +
            "and subjectId = :subjectId and date >= :dateTime ")
    List<SchoolBookSchedule> findAllBySchoolClassIDAndSubjectIdAndDate(@Param("schoolClassId") Long classId,
                                                                       @Param("dateTime") ZonedDateTime date,
                                                                       @Param("subjectId") Long subjectId);

}
