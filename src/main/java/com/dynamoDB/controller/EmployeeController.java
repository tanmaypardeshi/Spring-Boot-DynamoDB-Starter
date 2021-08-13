package com.dynamoDB.controller;

import com.dynamoDB.entity.Employee;
import com.dynamoDB.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    @PostMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") String employeeId) {
        return employeeRepository.deleteEmployee(employeeId);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable("id") String employeeId, Employee employee) {
       return employeeRepository.updateEmployee(employeeId, employee);
    }
}
