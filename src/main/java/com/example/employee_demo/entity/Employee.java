package com.example.employee_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee") // Maps to "employee" table in MySQL
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in MySQL
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "salary", nullable = false)
    private Double salary;

    // Default constructor (required by JPA)
    public Employee() {}

    // Parameterized constructor
    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

}