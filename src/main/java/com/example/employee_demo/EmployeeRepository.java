package com.example.employee_demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
