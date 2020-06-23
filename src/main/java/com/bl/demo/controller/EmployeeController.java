package com.bl.demo.controller;
import com.bl.demo.model.Employee;
import com.bl.demo.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/empinformation")
    public List<Employee> get() {
        return employeeService.get();
    }
}
