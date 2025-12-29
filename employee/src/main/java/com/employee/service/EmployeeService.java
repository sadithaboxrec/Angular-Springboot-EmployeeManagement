package com.employee.service;

import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    String deleteEmployee(Integer id);
}
