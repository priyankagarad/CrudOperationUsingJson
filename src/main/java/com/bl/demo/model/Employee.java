package com.bl.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
 public class Employee {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer id;
     private String name;
     private String city;
     private Date data;

    public Employee(Employee employee){
        name =employee.name;
        city =employee.city;
        data =employee.data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
