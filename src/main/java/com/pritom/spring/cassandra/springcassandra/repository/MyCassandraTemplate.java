package com.pritom.spring.cassandra.springcassandra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

@Repository
public class MyCassandraTemplate {

    @Autowired
    public CassandraOperations cassandraOperations;

    public MyCassandraTemplate() {
    }

    public <T> void create(T entity){
        cassandraOperations.insert(entity);
    }
}
