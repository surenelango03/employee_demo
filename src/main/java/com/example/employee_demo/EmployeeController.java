package com.example.employee_demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/getEmpNameUsingGet")
    public String getEmployeeNameUsingGet(@RequestParam String empId) {
        return "Employee Name for ID " + empId + " (via GET)";
    }

    @PostMapping("/getEmpNameUsingPost")
    public String getEmployeeNameUsingPost(@RequestBody EmployeeRequest request) {
        return "Employee Name for ID " + request.getEmpId() + " (via POST)";
    }
}
