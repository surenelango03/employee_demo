package com.example.employee_demo;

import com.example.employee_demo.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Convert Entity -> DTO
    private EmployeeDTO mapToDTO(Employee emp) {
        return new EmployeeDTO(emp.getId(), emp.getName(), emp.getDepartment(), emp.getRole());
    }

    // Convert DTO -> Entity
    private Employee mapToEntity(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setDepartment(dto.getDepartment());
        emp.setRole(dto.getRole());
        return emp;
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO dto) {
        if (employeeRepository.existsById(dto.getId())) {
            return ResponseEntity.badRequest().body("Employee with ID " + dto.getId() + " already exists!");
        }
        Employee employee = mapToEntity(dto);
        Employee saved = employeeRepository.save(employee);
        return ResponseEntity.ok(mapToDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp.map(e -> ResponseEntity.ok(mapToDTO(e)))
                  .orElse(ResponseEntity.notFound().build());
    }
}
