package com.example.employee_demo.service;

import com.example.employee_demo.dto.EmployeeDTO;

public interface EmployeeDetailsService {
    EmployeeDTO fetchEmployeeNameAndSalary(Long id);
}
