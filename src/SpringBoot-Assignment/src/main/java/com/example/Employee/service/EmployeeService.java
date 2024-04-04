package com.example.Employee.service;

import com.example.Employee.model.Address;
import com.example.Employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public abstract class EmployeeService {
    Page<Employee> getEmployeesByDepartment(String department, Pageable pageable) {
        return null;
    }


    public abstract List<Employee> getAllEmployees();

    public abstract Employee getEmployeeById(Long id);

    public abstract Employee addEmployee(Employee employee);

    public abstract Employee updateEmployee(Long id, Employee employee);

    public abstract void deleteEmployee(Long id);

    public abstract Page<Employee> getEmployeesByDepartment(String department, int page, int size);

    public abstract Employee addAddress(Long employeeId, Address address);

    public abstract void removeAddress(Long employeeId, Long addressId);
}
