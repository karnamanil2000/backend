package com.example.backend.service;

import com.example.backend.entity.Employee;
import com.example.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * @param employee
     * @return
     */
    @Override
    public String upsert(Employee employee) {
        employeeRepository.save(employee);
        return "success";
    }

    /**
     * @param eid
     * @return
     */
    @Override
    public Employee getById(Long eid) {
        Optional<Employee> findById = employeeRepository.findById(eid);
        if(findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * @param eid
     * @return
     */
    @Override
    public String deleteById(Long eid) {
        if(employeeRepository.existsById(eid)){
            employeeRepository.deleteById(eid);
            return "Delete Success";
        } else {
            return "No Records Found";
        }
    }
}
