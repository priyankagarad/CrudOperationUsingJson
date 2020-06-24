package com.bl.demo.repository;
import com.bl.demo.model.Employee;
import java.io.IOException;
import java.util.List;
public interface EmployeeInterface {
    List<Employee> getEmployeeDetail();
    Employee addEmployee(Employee user) throws IOException;
    Employee getEmployeeById(Integer id);
    void deleteByEmployeeId(Integer id);

}
