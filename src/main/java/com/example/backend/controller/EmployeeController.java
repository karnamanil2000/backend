package com.example.backend.controller;

import com.example.backend.entity.Employee;
import com.example.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        String status = employeeService.upsert(employee);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/employees/{eid}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long eid) {
        Employee employee = employeeService.getById(eid);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allEmployees= employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        String status = employeeService.upsert(employee);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{eid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long eid) {
        String status = employeeService.deleteById(eid);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
