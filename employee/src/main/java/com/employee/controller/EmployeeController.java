package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping
    public ResponseEntity< List<Employee>> getAllEmployees() {
        return ResponseEntity.ok( employeeService.getAllEmployees() );
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping
    public ResponseEntity <Employee> createEmployees(@RequestBody Employee employee) {
        return ResponseEntity.ok( employeeService.createEmployee(employee) );
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PutMapping("/{id}")
    public ResponseEntity <Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee) );
    }

    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id) );
    }

}
