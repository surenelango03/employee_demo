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

    // POST only
    @PostMapping("/getEmpNameUsingPost")
    public EmployeeDTO getEmpNameUsingPost(@RequestParam Long id) {
        return service.fetchEmployeeNameAndSalary(id);
    }

    // Accepts both GET and POST
    @RequestMapping(value = "/getEmpNameUsingGet", method = {RequestMethod.GET, RequestMethod.POST})
    public EmployeeDTO getEmpNameUsingGet(@RequestParam Long id) {
        return service.fetchEmployeeNameAndSalary(id);
    }
}