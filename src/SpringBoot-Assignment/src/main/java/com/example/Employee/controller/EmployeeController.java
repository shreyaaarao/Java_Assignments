package com.example.Employee.controller;

import com.example.Employee.model.Address;
import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/{employeeId}/addresses")
    public ResponseEntity<String> addAddress(@PathVariable("employeeId") Long employeeId, @RequestBody Address address) {
        employeeService.addAddress(employeeId, address);
        return ResponseEntity.ok("Address added successfully");
    }

    @GetMapping("/byDepartment")
    public List<Employee> getEmployeesByDepartment(@RequestParam String department,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        return (List<Employee>) employeeService.getEmployeesByDepartment(department, page, size);
    }
}
