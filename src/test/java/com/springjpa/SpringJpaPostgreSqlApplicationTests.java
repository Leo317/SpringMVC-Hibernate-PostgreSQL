package com.springjpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;


//@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJpaPostgreSqlApplicationTests {
	public void testApp() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void contextLoads() {
	}

}
