package com.example.employee_demo.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String department;
    private String role;

    // Constructors
    public EmployeeDTO() {}
    public EmployeeDTO(Long id, String name, String department, String role) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
