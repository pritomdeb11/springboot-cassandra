package com.pritom.spring.cassandra.springcassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackageClasses = MyCassandraTemplate.class)

public class SpringCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCassandraApplication.class, args);
	}
}
