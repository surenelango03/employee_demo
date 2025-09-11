package com.example.employee_demo.controller;

import com.example.employee_demo.dto.EmployeeDTO;
import com.example.employee_demo.service.EmployeeDetailsService;
import com.example.employee_demo.service.EmployeeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EmployeeController {
    private final EmployeeDetailsService service;

    public EmployeeController(EmployeeDetailsService service) {
        this.service = service;
    }

    // POST only
    @PostMapping("/getEmpNameUsingPost")
    public EmployeeDTO getEmpNameUsingPost(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        return service.fetchEmployeeNameAndSalary(id);
    }

    // Accepts both GET and POST
    @RequestMapping(value = "/getEmpNameUsingGet", method = {RequestMethod.GET, RequestMethod.POST})
    public EmployeeDTO getEmpNameUsingGet(@RequestParam Long id) {
        return service.fetchEmployeeNameAndSalary(id);
    }

    // Add new employee
    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try {
            String result = service.addEmployee(employeeRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}