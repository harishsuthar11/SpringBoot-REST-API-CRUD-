package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employee {
    private Integer empcode;
    private String name;
    private String email;

    public Employee(Integer empcode) {
        this.empcode = empcode;
    }

    public Employee(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEmpcode() {
        return empcode;
    }

    public void setEmpcode(Integer empcode) {
        this.empcode = empcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(Integer empcode, String name, String email) {
        super();
        this.empcode = empcode;
        this.name = name;
        this.email = email;
    }
    public Employee(){

    }

}
