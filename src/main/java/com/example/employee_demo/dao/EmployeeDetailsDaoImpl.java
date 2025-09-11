package com.example.employee_demo.dao;

import com.example.employee_demo.dto.EmployeeDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDetailsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    public EmployeeDTO getEmployeeNameAndSalary(Long id) {
        String sql = "SELECT name, salary FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(
            sql,
            (rs, _) -> new EmployeeDTO(rs.getString("name"), rs.getDouble("salary")),
            id
        );
    }
}