package com.pritom.spring.cassandra.springcassandra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;

@Configuration
@PropertySource(value = {"classpath:cassandra.properties"})
public class CassandraConfig {

    private static final String KEYSPACE = "cassandra.keyspace";
    private static final String CONTACT_POINTS = "cassandra.contactPoints";
    private static final String PORT = "cassandra.port";

    @Autowired
    private Environment environment;

    public CassandraConfig(Environment environment) {
        this.environment = environment;
    }

    public String getKEYSPACE() {
        return environment.getProperty(KEYSPACE);
    }

    public String getContactPoints() {
        return environment.getProperty(CONTACT_POINTS);
    }

    public int getPORT() {
        return Integer.parseInt(environment.getProperty(PORT));
    }

    @Bean
    public CassandraClusterFactoryBean cluster(){
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(getContactPoints());
        cluster.setPort(getPORT());
        return cluster;
    }

    @Bean
    public CassandraMappingContext mappingContext(){
        return new BasicCassandraMappingContext();
    }

    @Bean
    public CassandraConverter converter(){
        return new MappingCassandraConverter(mappingContext());
    }

    @Bean
    public CassandraSessionFactoryBean session() {
        CassandraSessionFactoryBean cassandraSessionFactoryBean = new CassandraSessionFactoryBean();
        cassandraSessionFactoryBean.setCluster(cluster().getObject());
        cassandraSessionFactoryBean.setKeyspaceName(getKEYSPACE());
        cassandraSessionFactoryBean.setConverter(converter());
        cassandraSessionFactoryBean.setSchemaAction(SchemaAction.NONE);
        return cassandraSessionFactoryBean;
    }

    @Bean
    public CassandraOperations cassandraTemplate(){
        return new CassandraTemplate(session().getObject());
    }
}
