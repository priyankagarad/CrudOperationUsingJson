/*******************************************************************************************************
 * @Purpose: Employee Controller class Map The Method like Get,Put,post,Delete .
 * @Author: Priyanka
 * @Date: 24/6/2020
 ******************************************************************************************************/

package com.bl.demo.controller;
import com.bl.demo.model.Employee;
import com.bl.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
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

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) throws IOException {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id,@RequestBody Employee employee ) throws IOException {
        employeeService.updateEmployee(id,employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteByEmployeeId(@PathVariable Integer id){
        employeeService.deleteByEmployeeId(id);
    }
}