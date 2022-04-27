package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.facades.dto.scheduleSchoolClass.DayOfWeekDTO;
import com.sharikoff977.firstProject.facades.dto.scheduleSchoolClass.LessonDTO;
import com.sharikoff977.firstProject.facades.dto.scheduleSchoolClass.ScheduleSchoolClassDTO;
import com.sharikoff977.firstProject.model.Schedule;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.model.enumeration.DayOfWeekEnum;
import com.sharikoff977.firstProject.model.enumeration.LessonEnum;
import com.sharikoff977.firstProject.repo.*;
import com.sharikoff977.firstProject.service.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleSchoolClassServiceImpl {

    private final SchoolClassRepo schoolClassRepo;
    private final ScheduleRepo scheduleRepo;
    private final SubjectRepo subjectRepo;
    private final TeacherRepo teacherRepo;
    private final SchoolRoomRepo schoolRoomRepo;

    public ScheduleSchoolClassDTO getScheduleSchoolClass(String className){

        ScheduleSchoolClassDTO scheduleSchoolClassDTO = new ScheduleSchoolClassDTO();

        SchoolClass schoolClass = schoolClassRepo.findByName(className);
        scheduleSchoolClassDTO.setSchoolClassId(schoolClass.getId());
        List<DayOfWeekDTO> days = Arrays.asList(new DayOfWeekDTO[7]);
        scheduleSchoolClassDTO.setDays(days);

        List<Schedule> schedules = scheduleRepo.findAllBySchoolClassId(schoolClass.getId());

        for (Schedule schedule : schedules){

            LessonDTO lesson = new LessonDTO();
            lesson.setTime(schedule.getLesson().getTimeOfLesson());
            lesson.setSubjectTitle(subjectRepo.getById(schedule.getSubjectId()).getTitle());
            lesson.setTeacherName(teacherRepo.getById(schedule.getTeacherId()).getName());
            lesson.setRoomNumber(schoolRoomRepo.getById(schedule.getSchoolRoomId()).getNumber());

            DayOfWeekDTO day = days.get(schedule.getDayOfWeek().getValue());
            if (day == null){
                day = new DayOfWeekDTO();
                day.setDay(schedule.getDayOfWeek());
                day.setLessons(new ArrayList<>());
                days.set(schedule.getDayOfWeek().getValue(), day);
            }
            //List<LessonDTO> lessons = day.getLessons();
            day.getLessons().add(lesson);

        }

        /*for (DayOfWeekEnum dayOfWeekEnum : DayOfWeekEnum.values()){

            DayOfWeekDTO day = new DayOfWeekDTO();
            day.setDay(dayOfWeekEnum);

            List<LessonDTO> lessons = new ArrayList<>();
            for (LessonEnum lessonEnum : LessonEnum.values()){

                LessonDTO lesson = null;

                for (Schedule schedule : schedules){
                    if (schedule.getDay() == dayOfWeekEnum && schedule.getLesson() == lessonEnum){
                        lesson = new LessonDTO();
                        lesson.setTime(lessonEnum.getLesson());
                        lesson.setSubjectTitle(subjectRepo.getById(schedule.getSubjectId()).getTitle());
                        lesson.setTeacherName(teacherRepo.getById(schedule.getTeacherId()).getName());
                        lesson.setRoomNumber(schoolRoomRepo.getById(schedule.getSchoolRoomId()).getNumber());
                    }
                }

                if (lesson == null){
                    lesson = new LessonDTO();
                    lesson.setTime(lessonEnum.getLesson());
                    lesson.setSubjectTitle(null);
                    lesson.setTeacherName(null);
                    lesson.setRoomNumber(null);
                }
                lessons.add(lesson);
            }
            days.add(day);
        }*/
        return scheduleSchoolClassDTO;
    }

}
