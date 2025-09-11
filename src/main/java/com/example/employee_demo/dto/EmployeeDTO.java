package com.example.employee_demo.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private Double salary;

    public EmployeeDTO(Long id, String name, Double salary) {
        this.id = id;        
        this.name = name;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getSalary() { return salary; }
    
    // Add setters if needed
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSalary(Double salary) { this.salary = salary; }
}