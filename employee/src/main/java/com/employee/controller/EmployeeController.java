package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/v1/employees")
    public ResponseEntity< List<Employee>> getAllEmployees() {
        return ResponseEntity.ok( employeeService.getAllEmployees() );
    }

    @PostMapping("/api/v1/employees")
    public ResponseEntity <Employee> createEmployees(@RequestBody Employee employee) {
        return ResponseEntity.ok( employeeService.createEmployee(employee) );
    }

    @PutMapping("/api/v1/employees/{id}")
    public ResponseEntity <Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee) );
    }

    @DeleteMapping("/api/v1/employees/{id}")
    public ResponseEntity <String> deleteEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id) );
    }

}
