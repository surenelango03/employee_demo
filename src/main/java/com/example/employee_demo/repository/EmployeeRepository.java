package com.example.employee_demo.repository;

import com.example.employee_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Custom query method to find employee by ID
    Employee findEmployeeById(Long id);
    
    // You can add more custom query methods as needed
    // Example: List<Employee> findByName(String name);
}