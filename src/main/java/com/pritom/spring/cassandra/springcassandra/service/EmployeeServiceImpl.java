package com.pritom.spring.cassandra.springcassandra.service;

import com.pritom.spring.cassandra.springcassandra.dao.EmployeeDAO;
import com.pritom.spring.cassandra.springcassandra.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void createEmployee(Employee employee) {
        employeeDAO.createEmployee(employee);
    }
}
