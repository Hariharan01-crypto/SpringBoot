package com.springboot.POC.GroceryManagemnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.POC.GroceryManagemnet.dao.CustomerRepositry;
import com.springboot.POC.GroceryManagemnet.pojo.Customer;

@Service
public class GroceryServiceImple implements GroceryService {

	@Autowired	
	private CustomerRepositry customerRepositry;
	
	
	@Override
	public List<Customer> findAll() {
		return customerRepositry.findAll();
	}
	

	public Customer findById(int theId) {
		Optional<Customer> result = customerRepositry.findById(theId);
		
		Customer theCustomer = null;
		
		if (result.isPresent()) {
			theCustomer = result.get();
		}
		else {

			throw new RuntimeException("Did not find product id - " + theId);
		}
		
		return theCustomer;
	}


	
	@Override
	public void save(Customer theCustomer) {
		customerRepositry.save(theCustomer);
	}

	public void deleteById(int theId) {
		customerRepositry.deleteById(theId);
	}


	public void deleteAll() {

		customerRepositry.deleteAll();
	}

}






