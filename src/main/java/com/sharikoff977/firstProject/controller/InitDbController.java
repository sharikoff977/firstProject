package com.sharikoff977.firstProject.controller;

import com.sharikoff977.firstProject.repo.EmployeeRepo;
import com.sharikoff977.firstProject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InitDbController {

    @Autowired
    EmployeeRepo employeeRepo;

    private void fillDatabase() {
        Employee employee1 = new Employee("Dima", "Sharovskiy");
        Employee employee2 = new Employee("Anna", "Parkhomenko");
        Employee employee3 = new Employee("Anton", "Solyanik");
        Employee employee4 = new Employee("Olya", "Hnashuk");

        employeeRepo.save(employee1);
        employeeRepo.save(employee2);
        employeeRepo.save(employee3);
        employeeRepo.save(employee4);

    }

    @GetMapping("/init-db")
    @ResponseBody
    public void initDb(){
        fillDatabase();
    }

    @GetMapping("/employees")
    @ResponseBody
    public List showAllEmployees(){
        List<Employee> employees = employeeRepo.findAll();
        return employees;
    }

    @GetMapping("/hire-employee")
    @ResponseBody
    public void hireEmployee(@RequestParam String firstName,
                             @RequestParam String lastName){
        Employee employee = new Employee(firstName, lastName);
        employeeRepo.save(employee);
    }

    @GetMapping("/fire-employee")
    @ResponseBody
    public void fireEmployee(@RequestParam String firstName,
                             @RequestParam String lastName){
        List<Employee> employees = employeeRepo.findAll();
        Long id = null;

        for (Employee empl : employees
             ) {
            if (empl.getFirstName().equals(firstName) && empl.getLastName().equals(lastName)){
                id = empl.getId();
            }
        }
        if (id != null){
            employeeRepo.deleteById(id);
        }
    }

    @GetMapping("/change-employee")
    @ResponseBody
    public Long changeEmployee(@RequestParam String firstNameSearch,
                               @RequestParam String lastNameSearch,
                               @RequestParam String firstName,
                               @RequestParam String lastName){
        List<Employee> employees = employeeRepo.findAll();
        Long id = 0L;

        for (Employee empl : employees
             ) {
            if (empl.getFirstName().equals(firstNameSearch) && empl.getLastName().equals(lastNameSearch)){
                id = empl.getId();
            }
        }

        Employee employee = employeeRepo.findById(id).orElseThrow();

        employee.setFirstName(firstName);
        employee.setLastName(lastName);

        employeeRepo.save(employee);

        return id;
    }
}
