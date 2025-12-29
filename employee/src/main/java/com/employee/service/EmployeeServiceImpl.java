package com.employee.service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee employeeobj = employeeRepository.findById(employee.getId()).get();
        if (employeeobj != null) {
            employeeobj.setEmail(employee.getEmail());
            employeeobj.setEmployeeName(employee.getEmployeeName());
            employeeobj.setEmployeeSalary(employee.getEmployeeSalary());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public String deleteEmployee(Integer id) {

        Employee employeeobj = employeeRepository.findById(id).get();
        String dltmsg=null;
        if (employeeobj != null) {
            employeeRepository.delete(employeeobj);
            dltmsg="Employee deleted successfully for id"+id;
        }

        return dltmsg ;
    }

}
