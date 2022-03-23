package com.sharikoff977.firstProject.service;

import com.sharikoff977.firstProject.model.Employee;

public interface EmployeeService {
    Long hireEmployee(Employee employee);
    Long fireEmployee(String firstName, String lastName);
}
