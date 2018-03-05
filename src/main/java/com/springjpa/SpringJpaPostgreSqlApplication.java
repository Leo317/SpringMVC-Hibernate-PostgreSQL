package com.springjpa;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaPostgreSqlApplication implements CommandLineRunner{

	
	public static void main(String[] args){
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();  
		  
		MetadataImplementor metadataImplementor = (MetadataImplementor)  
		new MetadataSources(serviceRegistry).buildMetadata();  
		  
		SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);  
		export.create(true, true);  
		
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
