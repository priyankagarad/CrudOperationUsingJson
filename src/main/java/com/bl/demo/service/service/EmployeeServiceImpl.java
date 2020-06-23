package com.bl.demo.service.service;
import com.bl.demo.model.Employee;
import com.bl.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public List<Employee> get() {
        List<Employee> employeeList = employeeRepository.get();
        return employeeList;
    }

}