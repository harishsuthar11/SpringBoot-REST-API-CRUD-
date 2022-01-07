package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
        @Autowired
        private EmployeeRepository repo;
        public List<Employee> listAll() {
            return repo.findAll();
        }

        public void save(Employee product) {
            repo.save(product);
        }

        public Employee get(Integer id) {
            return repo.findById(id).get();
        }

        public void delete(Integer id) {
            repo.deleteById(id);
        }
    }

