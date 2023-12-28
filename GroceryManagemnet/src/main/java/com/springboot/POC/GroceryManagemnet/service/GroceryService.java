package com.springboot.POC.GroceryManagemnet.service;

import java.util.List;

import com.springboot.POC.GroceryManagemnet.pojo.Customer;


public interface GroceryService {

	public List<Customer> findAll();
	
	public  Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);

	public void deleteAll();
}
