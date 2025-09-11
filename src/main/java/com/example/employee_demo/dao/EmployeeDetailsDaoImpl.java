package com.example.employee_demo.dao;

import com.example.employee_demo.dto.EmployeeDTO;
import com.example.employee_demo.entity.Employee;
import com.example.employee_demo.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {

    private final EmployeeRepository employeeRepository;

    public EmployeeDetailsDaoImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO getEmployeeNameAndSalary(Long id) {
        // Use JpaRepository to find the entity
        Employee employee = employeeRepository.findEmployeeById(id);
        
        if (employee == null) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
        
        // Convert Entity to DTO
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getSalary());
    }
}