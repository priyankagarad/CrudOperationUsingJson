package com.bl.demo.service.service;
import com.bl.demo.model.Employee;
import com.bl.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeDetail() {
        List<Employee> userList = employeeRepository.getEmployeeDetail();
        return userList;
    }

    public Employee addEmployee(Employee employee) throws IOException {
        return employeeRepository.addEmployee(employee);
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.getEmployeeById(id);
    }

    public void deleteByEmployeeId(Integer id) {
        employeeRepository.deleteByEmployeeId(id);
    }

}