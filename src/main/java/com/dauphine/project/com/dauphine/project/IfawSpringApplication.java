package com.dauphine.project.com.dauphine.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

@EnableJpaRepositories("com.dauphine.project.repository")
@EnableTransactionManagement
@ComponentScan(basePackages={"com.dauphine"})
@EntityScan(basePackages="com.dauphine.project.entity")

public class IfawSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IfawSpringApplication.class, args);
	}

}
