package com.example.employee_demo.controller;

import com.example.employee_demo.dto.EmployeeDTO;
import com.example.employee_demo.service.EmployeeDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeDetailsService service;

    public EmployeeController(EmployeeDetailsService service) {
    this.service = service;
    }

    // POST: Accepts EmployeeDTO from request body
    @PostMapping("/getEmpNameUsingPost")
    public EmployeeDTO getEmpNameUsingPost(@RequestBody EmployeeDTO dto) {
        return service.fetchEmployeeNameAndSalary(dto.getId());
    }

    // GET: Accepts ID as request parameter
    @GetMapping("/getEmpNameUsingGet")
    public EmployeeDTO getEmpNameUsingGet(@RequestParam Long id) {
        return service.fetchEmployeeNameAndSalary(id);
    }

}