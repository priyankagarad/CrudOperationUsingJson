package com.bl.demo.service.service;
import com.bl.demo.model.Employee;
import com.bl.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeDetail() {
        List<Employee> userList = employeeRepository.getEmployeeDetail();
        return userList;
    }


}