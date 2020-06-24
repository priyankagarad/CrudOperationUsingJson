package com.bl.demo.repository;
import com.bl.demo.model.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.List;

public class EmployeeRepository {
    public List<Employee> employeeList;

    public List<Employee> loadEmployeeData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream  inputStream = new FileInputStream(new File("./src/main/resources/Empoyee.json"));
            com.fasterxml.jackson.core.type.TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>() {
            };
            employeeList = mapper.readValue(inputStream, typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<Employee> get() {
        List<Employee> employeeList = loadEmployeeData();
        return employeeList;
    }

    @Override
    public Employee addEmployee(Employee employee) throws IOException {
        employeeList.add(employee);
        objectMapper.writeValue(new File("./src/main/resources/EmployeeDetail.json"), employeeList);
        return employee;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        if(id!=null) {
            Employee e = employeeList.stream().filter(employee -> employee.getId() == id).findAny().get();
            return e;
        }

        return null;
    }

    @Override
    public void deleteByEmployeeId(Integer id) {
        Employee remove=null;
        Employee e = employeeList.stream().filter(employee -> employee.getId() == id).findAny().get();
        if(e.getId()==id){
            remove=e;
        }

        if (remove!=null){
            employeeList.remove(remove);
            try {
                objectMapper.writeValue(new File("./src/main/resources/EmployeeDetail.json"), employeeList);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }



}