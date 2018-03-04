package com.springjpa.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjpa.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {
	
	@Autowired
    SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void creat(Customer customer) {
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

	@Override
	public void update(Customer customer) {
		System.out.println(customer);

		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.update(customer);
//		session.getTransaction().commit();
//		session.close();
		session.beginTransaction();
		
		String HQL = "update customer set phone=:phone,"
				+ " fistName=:firstName, lastName=:lastName where id = :id";
		Query query = session.createQuery(HQL);
		query.setParameter("phone", customer.getPhone());
		query.setParameter("firstName", customer.getFirstName());
		query.setParameter("lastName", customer.getLastName());
		query.setParameter("id", customer.getId());
		try {
			int executeUpdate = query.executeUpdate();
			if (executeUpdate > 0)
				System.out.println("Update Successfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
		session.close();
		
		  
//		Customer result = new Customer();
//		result.setId(id);
//		result.setPhone(customer.getPhone());
//		result.setFirstName(customer.getFirstName());
//		result.setLastName(customer.getLastName());
//		
//		System.out.println(result);
//		Session session = sessionFactory.openSession();
//        session.beginTransaction();
//     
//        session.update(result);
//     
//        session.getTransaction().commit();
//        session.close();
	}

	@Override
	public Customer edit(long id) {
		// TODO Auto-generated method stub
		return find(id);
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Customer result = new Customer();
        result = (Customer)session.load(Customer.class,id);
        session.delete(result);
        
        session.getTransaction().commit();
        session.close();
	}
	
	@Override
	public Customer find(long id) {
		return (Customer)currentSession().get(Customer.class, id);
	}

	@Override
	public String getAll() {
		// TODO Auto-generated method stub
//		return currentSession().createCriteria(Customer.class).list();
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
