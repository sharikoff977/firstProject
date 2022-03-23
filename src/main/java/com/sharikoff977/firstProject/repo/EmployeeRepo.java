package com.sharikoff977.firstProject.repo;

import com.sharikoff977.firstProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
