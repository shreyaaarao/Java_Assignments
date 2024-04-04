package com.example.Employee.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String address;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Address(Long addressId, String address, Employee employee) {
        this.addressId = addressId;
        this.address = address;
        this.employee = employee;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
