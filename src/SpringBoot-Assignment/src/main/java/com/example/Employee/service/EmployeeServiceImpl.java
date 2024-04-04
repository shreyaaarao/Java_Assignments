package com.example.Employee.service;

import com.example.Employee.model.Address;
import com.example.Employee.model.Employee;
import com.example.Employee.repository.AddressRepository;
import com.example.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl extends EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setSkill(employee.getSkill());
            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> getEmployeesByDepartment(String department, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findByDepartment(department, pageable);
    }

    @Override
    public Employee addAddress(Long employeeId, Address address) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            address.setEmployee(employee);
            addressRepository.save(address);
        }
        return null;
    }

    @Override
    public void removeAddress(Long employeeId, Long addressId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            Optional<Address> optionalAddress = addressRepository.findById(addressId);
            if (optionalAddress.isPresent()) {
                Address address = optionalAddress.get();
                if (address.getEmployee().equals(employee)) {
                    addressRepository.deleteById(addressId);
                }
            }
        }
    }
}
