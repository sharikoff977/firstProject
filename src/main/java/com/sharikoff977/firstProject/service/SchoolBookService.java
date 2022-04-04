package com.sharikoff977.firstProject.service;

import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.model.Student;

public interface SchoolBookService {

    Long hireEmployee(Student student);
    Long fireEmployee(String firstName, String lastName);
}
