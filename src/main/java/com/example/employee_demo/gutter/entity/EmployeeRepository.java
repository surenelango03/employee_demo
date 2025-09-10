package com.example.employee_demo.gutter.entity;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.example.employee_demo.gutter.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
