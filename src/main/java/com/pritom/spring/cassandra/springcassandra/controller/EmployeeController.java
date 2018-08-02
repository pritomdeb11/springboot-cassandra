package com.pritom.spring.cassandra.springcassandra.controller;

import com.pritom.spring.cassandra.springcassandra.entity.Employee;
import com.pritom.spring.cassandra.springcassandra.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
        System.out.println("Employee Constructor ...");
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }
}
