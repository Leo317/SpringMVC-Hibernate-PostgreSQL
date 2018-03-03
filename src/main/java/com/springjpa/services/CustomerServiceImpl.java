package com.springjpa.services;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
    SessionFactory sessionFactory;
	
	public void add(Customer customer) {
		Customer temp = new Customer();
		temp.setPhone(customer.getPhone());
		temp.setFirstName(customer.getFirstName());
		temp.setLastName(customer.getLastName());
		
		Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(temp);
     
        session.getTransaction().commit();
        session.close();
	}
	
	public void delete(long id) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Customer result = new Customer();
        result = (Customer)session.load(Customer.class,id);
        session.delete(result);
        
        session.getTransaction().commit();
        session.close();
	}
	
	public void update(long id, Customer customer) {
		System.out.println(id);

		Customer result = new Customer();
		result.setId(id);
		result.setPhone(customer.getPhone());
		result.setFirstName(customer.getFirstName());
		result.setLastName(customer.getLastName());
		
		System.out.println(result);
		Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(result);
     
        session.getTransaction().commit();
        session.close();
	}
	
	public String findAll() {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        
		Criteria criteria = session.createCriteria(Customer.class);
        List users = criteria.list();
        Iterator iterator =  users.iterator();

        String result = "";
        
        while(iterator.hasNext()) {
        	result += iterator.next().toString() + "<br>";
        }
		return result;
	}
}
