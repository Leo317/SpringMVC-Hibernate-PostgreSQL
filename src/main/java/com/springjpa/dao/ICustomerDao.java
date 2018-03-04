package com.springjpa.dao;

import java.util.List;

import com.springjpa.model.Customer;

public interface ICustomerDao {
//	public void add(Customer customer);
//	public void delete(long id);
//	public void update(long id, Customer customer);
//	public String findAll();
	
	public void creat(Customer customer);
	public void update(Customer customer);
	public Customer edit(long id);
	public void delete(long id);
	public Customer find(long id);
	public String getAll();
}
