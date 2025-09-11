package com.example.employee_demo.service;

import com.example.employee_demo.dao.EmployeeDetailsDao;
import com.example.employee_demo.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
    private final EmployeeDetailsDao employeeDetailsDao;

    public EmployeeDetailsServiceImpl(EmployeeDetailsDao employeeDetailsDao) {
        this.employeeDetailsDao = employeeDetailsDao;
    }

    @Override
    public EmployeeDTO fetchEmployeeNameAndSalary(Long id) {    
        return employeeDetailsDao.getEmployeeNameAndSalary(id);
    }

    @Override
    public String addEmployee(EmployeeRequest employee) {
        try {
            employeeDetailsDao.addEmployee(employee);
            return "Employee added successfully";
        } catch (Exception e) {
            return "Error adding employee: " + e.getMessage();
        }
    }
}