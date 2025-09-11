package com.example.employee_demo.dao;

import com.example.employee_demo.dto.EmployeeDTO;
import com.example.employee_demo.service.EmployeeRequest;

public interface EmployeeDetailsDao {
    EmployeeDTO getEmployeeNameAndSalary(Long id);
    void addEmployee(EmployeeRequest employee);
}