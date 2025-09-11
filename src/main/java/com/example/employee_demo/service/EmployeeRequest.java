package com.example.employee_demo.service;

public class EmployeeRequest {
    private String name;
    private Double salary;

    // Default constructor
    public EmployeeRequest() {}

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}