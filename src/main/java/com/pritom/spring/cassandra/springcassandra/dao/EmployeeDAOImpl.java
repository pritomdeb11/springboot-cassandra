package com.pritom.spring.cassandra.springcassandra.dao;

import com.pritom.spring.cassandra.springcassandra.entity.Employee;
import com.pritom.spring.cassandra.springcassandra.repository.MyCassandraTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {


    @Autowired
    private MyCassandraTemplate cassandraTemplate;

    @Override
    public void createEmployee(Employee employee) {
        cassandraTemplate.create(employee);
    }
}
