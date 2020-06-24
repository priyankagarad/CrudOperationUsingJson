package com.bl.demo.controller;
import com.bl.demo.model.Employee;
import com.bl.demo.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employeeDetail")
    public List<Employee> getEmployeeDetail(){
        return employeeService.getEmployeeDetail();
    }

}
