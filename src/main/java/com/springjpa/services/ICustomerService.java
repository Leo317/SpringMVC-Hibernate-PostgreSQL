package com.springjpa.services;

import com.springjpa.model.Customer;

public interface ICustomerService {
	public void add(Customer customer);
	public void delete(long id);
	public void update(long id, Customer customer);
	public String findAll();
}
