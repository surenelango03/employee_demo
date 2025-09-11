package com.example.employee_demo.dao;

import com.example.employee_demo.dto.EmployeeDTO;
import com.example.employee_demo.service.EmployeeRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDetailsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public EmployeeDTO getEmployeeNameAndSalary(Long id) {
        String sql = "SELECT name, salary FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(
            sql,
            (rs, _) -> new EmployeeDTO(rs.getString("name"), rs.getDouble("salary")),
            id
        );
    }

    @Override
    public void addEmployee(EmployeeRequest employee) {
        String sql = "INSERT INTO employee (name, salary) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getSalary());
    }
}