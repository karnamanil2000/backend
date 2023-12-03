package com.example.backend.service;

import com.example.backend.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public String upsert(Employee employee);

    public Employee getById(Long eid);

    public List<Employee> getAllEmployees();

    public String deleteById(Long eid);
}
