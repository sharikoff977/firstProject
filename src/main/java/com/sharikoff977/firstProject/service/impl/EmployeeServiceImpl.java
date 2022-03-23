package com.sharikoff977.firstProject.service.impl;

import com.sharikoff977.firstProject.repo.EmployeeRepo;
import com.sharikoff977.firstProject.model.Employee;
import com.sharikoff977.firstProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Long hireEmployee(Employee employee) {
        Long id = employeeRepo.save(employee).getId();

        return id;
    }

    @Override
    public Long fireEmployee(String firstName, String lastName) {
        Iterable<Employee> employees = employeeRepo.findAll();
        Long id = null;

        for (Employee employee : employees
             ) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)){
                id = employee.getId();
            }
        }

        if (id != null){
            employeeRepo.deleteById(id);
        }

        return id;
    }
}
