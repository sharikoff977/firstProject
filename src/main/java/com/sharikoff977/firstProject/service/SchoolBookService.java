package com.sharikoff977.firstProject.service;

import com.sharikoff977.firstProject.facades.dto.schoolBook.SchoolBookDTO;
import com.sharikoff977.firstProject.model.SchoolClass;
import com.sharikoff977.firstProject.model.Student;

public interface SchoolBookService {
    SchoolBookDTO getSchoolBook(String className);
}
