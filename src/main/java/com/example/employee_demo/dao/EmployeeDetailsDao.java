package com.example.employee_demo.dao;

import com.example.employee_demo.dto.EmployeeDTO;

public interface EmployeeDetailsDao {
    EmployeeDTO getEmployeeNameAndSalary(Long id);
}
