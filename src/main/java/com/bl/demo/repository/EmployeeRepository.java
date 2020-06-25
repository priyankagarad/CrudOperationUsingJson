package com.bl.demo.repository;
import com.bl.demo.model.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeRepository implements EmployeeInterface {
    private List<Employee> employeeList;

    private InputStream inputStream;
    private ObjectMapper objectMapper;

    public EmployeeRepository(){
        objectMapper=new ObjectMapper();
        try {
            inputStream=new FileInputStream(new File("./src/main/resources/EmployeeDetail.json"));
            TypeReference<List<Employee>>typeReference=new TypeReference<List<Employee>>() {
            };
            employeeList =objectMapper.readValue(inputStream,typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getEmployeeDetail() {
        return employeeList;
    }

    @Override
    public Employee addEmployee(Employee employee) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        employee.setDate(date);
        employeeList.add(employee);
        objectMapper.writeValue(new File("./src/main/resources/EmployeeDetail.json"), employeeList);
        return employee;
    }

    @Override
    public void updateEmployee(Integer id, Employee employee) throws IOException {
        Employee employeeById = getEmployeeById(id);
        employeeById.setName((employee.getName() == null) ? employeeById.getName() : employee.getName());
        employeeById.setCity((employee.getCity() == null) ? employeeById.getCity() : employee.getCity());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        employeeById.setDate(date);
        employeeList.set(employeeList.indexOf(employeeById), employeeById);
        objectMapper.writeValue(new File("./src/main/resources/EmployeeDetail.json"), employeeList);
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