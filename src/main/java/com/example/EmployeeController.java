package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping("/employees")
    public List<Employee> list() {
        return service.listAll();
    }
    @GetMapping("/employees/{empcode}")
    public ResponseEntity<Employee> get(@PathVariable Integer empcode) {
        try {
            Employee employee = service.get(empcode);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/employees")
    public void add(@RequestBody Employee employee) {
        service.save(employee);
    }
    @PutMapping("/employees/{empcode}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer empcode) {
        try {
           Employee existProduct = service.get(empcode);
            service.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/employees/{empcode}")
    public void delete(@PathVariable Integer empcode) {
        service.delete(empcode);
    }


}
