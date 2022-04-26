package com.sharikoff977.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sharikoff977.firstProject.facades.dto.ScheduleDTO;
import com.sharikoff977.firstProject.facades.dto.SubjectDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SbStudentGradeDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SbSubjectDTO;
import com.sharikoff977.firstProject.facades.dto.schoolBook.SchoolBookDTO;
import com.sharikoff977.firstProject.service.SchoolBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SchoolBookController {

  @Autowired
  private SchoolBookService schoolBookService;

  @GetMapping("/api/school-book/{clazz}")
  public SchoolBookDTO getSchoolBook(@PathVariable("clazz") String clazz) throws JsonProcessingException {
    SchoolBookDTO schoolBook = schoolBookService.getSchoolBook(clazz);
    /*Integer maxGradesCount = schoolBook.getSubjects().stream()
        .map(SbSubjectDTO::getStudentGrades)
        .flatMap(List::stream)
        .map(SbStudentGradeDTO::getGrades)
        .map(List::size)
        .max(Integer::compareTo).orElse(0);*/
    Map<SubjectDTO, List<ZonedDateTime>> subjectSchedulesMap = new HashMap<>();
    for (SbSubjectDTO subject : schoolBook.getSubjects()){
      subjectSchedulesMap.put(subject.getSubject(), subject.getSchedules());
    }
    return schoolBook;
  }
    /*@Autowired
    StudentRepo studentRepo;
    @Autowired
    SchoolClassRepo schoolClassRepo;
    @Autowired
    SubjectRepo subjectRepo;
    @Autowired
    GradeRepo gradeRepo;*/
/*
    private final SchoolClassFacade schoolClassFacade;

    private void fillDatabase() {
        log.debug("Start to filling database");
        // Create school classes
        log.debug("Create school classes");
        SchoolClassDTO schoolClassDTO1a = new SchoolClassDTO(1,'a');
        SchoolClass schoolClass1b = new SchoolClass(1,'b');
        SchoolClass schoolClass1c = new SchoolClass(1,'c');
        // create students
        log.debug("Create students");
        Student student1a_1 = new Student("Dima", "Sharovskiy"*//*,schoolClass1a*//*);
        Student student1a_2 = new Student("Anna", "Parkhomenko"*//*,schoolClass1a*//*);
        Student student1b_1 = new Student("Anton", "Solyanik"*//*,schoolClass1b*//*);
        Student student1b_2 = new Student("Olya", "Hnashuk"*//*,schoolClass1b*//*);
        Student student1b_3 = new Student("Elona", "Kanarska"*//*,schoolClass1b*//*);
        Student student1c_1 = new Student("Oleg", "Gnashuk"*//*,schoolClass1c*//*);
        Student student1c_2 = new Student("Dashka", "Kakashka"*//*,schoolClass1c*//*);
        Student student1c_3 = new Student("Ren", "Vsempuzdec"*//*,schoolClass1c*//*);
        // Add students to schoolclasses
        schoolClass1a.getStudents().add(student1a_1);
        schoolClass1a.getStudents().add(student1a_2);

        //schoolClass1b.setStudents(new HashSet<>());
        schoolClass1b.getStudents().add(student1b_1);
        schoolClass1b.getStudents().add(student1b_2);
        schoolClass1b.getStudents().add(student1b_3);

        //schoolClass1c.setStudents(new HashSet<>());
        schoolClass1c.getStudents().add(student1c_1);
        schoolClass1c.getStudents().add(student1c_2);
        schoolClass1c.getStudents().add(student1c_3);
        // save students
        studentRepo.save(student1a_1);
        studentRepo.save(student1a_2);
        studentRepo.save(student1b_1);
        studentRepo.save(student1b_2);
        studentRepo.save(student1b_3);
        studentRepo.save(student1c_1);
        studentRepo.save(student1c_2);
        studentRepo.save(student1c_3);*//*
        // save schoolclasses
        schoolClassRepo.save(schoolClass1a);
        schoolClassRepo.save(schoolClass1b);
        schoolClassRepo.save(schoolClass1c);

        // create subjects
        Subject maths = new Subject("maths");
        Subject language = new Subject("language");
        Subject reading = new Subject("reading");

        subjectRepo.save(maths);
        subjectRepo.save(language);
        subjectRepo.save(reading);

        // create grades
        Grade grade1 = new Grade(maths,student1a_1,4,ZonedDateTime.now());
        Grade grade2 = new Grade(maths,student1a_2,5,ZonedDateTime.now());
        Grade grade3 = new Grade(language,student1b_1,6,ZonedDateTime.now());
        Grade grade4 = new Grade(language,student1b_2,7,ZonedDateTime.now());
        Grade grade5 = new Grade(language,student1b_3,8,ZonedDateTime.now());
        Grade grade6 = new Grade(reading,student1c_1,9,ZonedDateTime.now());
        Grade grade7 = new Grade(reading,student1c_2,10,ZonedDateTime.now());
        Grade grade8 = new Grade(reading,student1c_3,11,ZonedDateTime.now());
        gradeRepo.save(grade1);
        gradeRepo.save(grade2);
        gradeRepo.save(grade3);
        gradeRepo.save(grade4);
        gradeRepo.save(grade5);
        gradeRepo.save(grade6);
        gradeRepo.save(grade7);
        gradeRepo.save(grade8);

    }
    /*
    Function call fillDatabase()
     *//*
    @GetMapping("/init-db")
    @ResponseBody
    public void initDb(){
        fillDatabase();
    }
    *//*
    Withdrawal of all students
     *//*
    @GetMapping("/students")
    @ResponseBody
    public Object showAllStudents(){
        List<Student> students = studentRepo.findAll();
        return students;
    }
    *//*
    Withdrawal of all school classes
     *//*
    @GetMapping("/schoolclasses")
    @ResponseBody
    public Object showAllSchollClasses(){
        List<SchoolClass> schoolClasses = schoolClassRepo.findAll();
        return schoolClasses;
    }
    *//*
    Withdrawal of all subjects
     *//*
    @GetMapping("/subjects")
    @ResponseBody
    public Object showAllSubjects(){
        List<Subject> subjects = subjectRepo.findAll();
        return subjects;
    }
    *//*
    Withdrawal of all grades
     *//*
    @GetMapping("/grades")
    @ResponseBody
    public Object showAllGrades(){
        List<Grade> grades = gradeRepo.findAll();
        return grades;
    }
    *//*
    Adding schoolClass
     *//*
    @GetMapping("/add-schoolclass")
    @ResponseBody
    public Long addSchoolClass(@RequestParam int number,
                             @RequestParam char letter){
        Long id = 0L;
        SchoolClass schoolClass = new SchoolClass(number, letter);
        id = schoolClassRepo.save(schoolClass).getId();

        return id;
    }
    *//*
    Adding students
     *//*
    @GetMapping("/add-students")
    @ResponseBody
    public void addStudents(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam Long schoolClassId){
        Student student = new Student(firstName,lastName);
        *//*Optional<SchoolClass> schoolClassOptional = schoolClassRepo.findById(schoolClassId);
        List<SchoolClass> schoolClasses = new ArrayList<>();
        schoolClassOptional.ifPresent(schoolClasses::add);*//*
        if (schoolClassRepo.existsById(schoolClassId)){
            SchoolClass schoolClass = schoolClassRepo.getById(schoolClassId);
            schoolClass.getStudents().add(student);
            schoolClassRepo.save(schoolClass);
        }
    }
    *//*
    Adding subjects
     *//*
    @GetMapping("/add-subject")
    @ResponseBody
    public Long addSubject(@RequestParam String title){
        Long id = 0L;
        Subject subject = new Subject(title);
        id = subjectRepo.save(subject).getId();

        return id;
    }
    *//*
    Adding grades
     *//*
    @GetMapping("/add-grade")
    @ResponseBody
    public Long addGrade(@RequestParam Long idSubject,
                         @RequestParam Long idStudent,
                         @RequestParam int value,
                         @RequestParam int year,
                         @RequestParam int month,
                         @RequestParam int dayofMonth,
                         @RequestParam int hour,
                         @RequestParam int minute){
        Long id = 0L;
        Subject subject = new Subject();
        if (subjectRepo.existsById(idSubject)){
            subject = subjectRepo.getById(idSubject);
        }
        Student student = new Student();
        if(studentRepo.existsById(idStudent)){
            student = studentRepo.getById(idStudent);
        }
        Grade grade = new Grade(subject,student,value,ZonedDateTime.of(LocalDateTime.of(year, Month.of(month),dayofMonth,hour,minute), ZoneId.of("Europe/Kiev")));
        id = gradeRepo.save(grade).getId();

        return id;
    }
    *//*
    Show grades of student
     *//*
    @GetMapping("/show-grades-of-student")
    @ResponseBody
    public List<Grade> showAllGradesOfStudent(@RequestParam Long id){
        Student student = new Student();
        if (studentRepo.existsById(id)){
            //student = studentRepo.getById(id);
            student = studentRepo.findById(id).get();
        }
        List<Grade> grades = gradeRepo.findAll();
        List<Grade> gradesId = new ArrayList<>();
        for (Grade grade : grades
             ) {
            if (grade.getStudent().getId() == id){
                gradesId.add(grade);
            }
        }
        return gradesId;
    }
    *//*
    Show grades of student by date
     *//*
    @GetMapping("/show-grades-of-student-by-date")
    @ResponseBody
    public List<Grade> showAllGradesOfStudentByDate(@RequestParam Long id,
                                                    @RequestParam int year,
                                                    @RequestParam int month,
                                                    @RequestParam int dayOfMonth){
        Student student = new Student();
        if (studentRepo.existsById(id)){
            //student = studentRepo.getById(id);
            student = studentRepo.findById(id).get();
        }
        List<Grade> grades = gradeRepo.findAll();
        List<Grade> gradesId = new ArrayList<>();
        for (Grade grade : grades
        ) {
            if (grade.getStudent().getId() == id & grade.getDateTime().equals(ZonedDateTime.of(LocalDateTime.of(year,Month.of(month),dayOfMonth,0,0),ZoneId.of("Europe/Kiev")))){
                gradesId.add(grade);
            }
        }
        return gradesId;
    }
    *//*
    Editing school class
     *//*
    @GetMapping("/edit-schoolclass")
    @ResponseBody
    public int editingSchoolClass(@RequestParam Long id,
                                   @RequestParam int number,
                                   @RequestParam char letter){
        if (schoolClassRepo.existsById(id)){
            SchoolClass schoolClass = schoolClassRepo.findById(id).get();
            schoolClass.setNumber(number);
            schoolClass.setLetter(letter);
            schoolClassRepo.save(schoolClass);
            return 1;
        }
        return 0;
    }
    *//*
    Editing student
     *//*
    @GetMapping("/edit-student")
    @ResponseBody
    public int editStudent(@RequestParam Long id,
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam Long idSchoolClass){
        if (studentRepo.existsById(id)){
            Student student = studentRepo.findById(id).get();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            if (schoolClassRepo.existsById(idSchoolClass)){
                SchoolClass schoolClass = schoolClassRepo.findById(idSchoolClass).get();
                schoolClass.getStudents().add(student);
                schoolClassRepo.save(schoolClass);
            }
            return 1;
        }
        return 0;
    }
    *//*
    Editing grade
     *//*
    @GetMapping("/edit-grade")
    @ResponseBody
    public int editGrade(@RequestParam Long id,
                         @RequestParam int value){
        if (gradeRepo.existsById(id)){
            Grade grade = gradeRepo.findById(id).get();
            grade.setValue(value);
            gradeRepo.save(grade);
            return 1;
        }
        return 0;
    }
    *//*
    Delete school class
     *//*
    @GetMapping("/delete-school-class")
    @ResponseBody
    public ResponseEntity deleteSchoolClass(@RequestParam Long id){

        *//*if (schoolClassRepo.existsById(id)){
            SchoolClass schoolClass = schoolClassRepo.findById(id).orElseThrow();
            schoolClassRepo.delete(schoolClass);
            return 1;
        }
        return 0;*//*
        try {
            schoolClassRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    *//*
    Delete student
     *//*
    @GetMapping("/delete-student")
    @ResponseBody
    public ResponseEntity deleteStudent(@RequestParam Long id){
        *//*if (studentRepo.existsById(id)){
            Student student = studentRepo.findById(id).orElseThrow();
            studentRepo.delete(student);
            studentRepo.deleteById(id);
            return 1;
        }*//*
        try
        {
            studentRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }*/
}
