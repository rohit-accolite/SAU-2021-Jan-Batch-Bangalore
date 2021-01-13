package com.example.au.couchbasedemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeRepository empRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee emp) {
        return empRepository.save(emp);
    }
    
    @GetMapping("/employee/pin/{pin}")
    public List<Employee> getEmployeeByPin(@PathVariable String pin) {
        return empRepository.findByPin(pin);
    }
    
    @GetMapping("/employee/location/{location}")
    public List<Employee> getEmployeeByLocation(@PathVariable String location) {
        return empRepository.findByLocation(location);
    }
    

}