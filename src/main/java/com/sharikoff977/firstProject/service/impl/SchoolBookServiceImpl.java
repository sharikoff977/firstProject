package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.repo.StudentRepo;
import com.sharikoff977.firstProject.model.Student;
import com.sharikoff977.firstProject.service.SchoolBookService;
import org.springframework.beans.factory.annotation.Autowired;

public class SchoolBookServiceImpl implements SchoolBookService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Long hireEmployee(Student student) {
        Long id = studentRepo.save(student).getId();

        return id;
    }

    @Override
    public Long fireEmployee(String firstName, String lastName) {
        Iterable<Student> employees = studentRepo.findAll();
        Long id = null;

        for (Student student : employees
             ) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                id = student.getId();
            }
        }

        if (id != null){
            studentRepo.deleteById(id);
        }

        return id;
    }
}
