package com.springjpa;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaPostgreSqlApplication implements CommandLineRunner{

	
	public static void main(String[] args){
		SpringApplication.run(SpringJpaPostgreSqlApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// clear all record if existed before do the tutorial with new data 
//		repository.deleteAll();
	}
	
	@Bean    
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){    
	    return hemf.getSessionFactory();    
	}     
}
