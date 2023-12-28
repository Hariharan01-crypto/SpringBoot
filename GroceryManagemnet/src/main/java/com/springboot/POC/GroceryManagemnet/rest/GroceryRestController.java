package com.springboot.POC.GroceryManagemnet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.POC.GroceryManagemnet.pojo.Customer;
import com.springboot.POC.GroceryManagemnet.service.GroceryService;

@RestController
@RequestMapping("/grocery")
public class GroceryRestController {

	@Autowired
	private GroceryService grocery;
	
	// add mapping for POST 
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer theCustomer) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theCustomer.setId(0);
		
		grocery.save(theCustomer);
		
		return new ResponseEntity<Customer>(theCustomer, HttpStatus.OK);
	}
	
	
	

	@GetMapping("/customer")
	public List<Customer> findAll() {
		return grocery.findAll();
	}

	// add mapping for GET /
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getProduct(@PathVariable int customerId) {
		
		Customer theCustomer = grocery.findById(customerId);
		
		if (theCustomer == null) {
			throw new RuntimeException();
		}
		
		return new ResponseEntity<Customer>(theCustomer, HttpStatus.OK);
	}
	

	// add mapping for PUT 
	
	@PutMapping("/customer")
	public Customer updateProduct(@RequestBody Customer theCustomer) {
		
		grocery.save(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for DELETE All
	
	@DeleteMapping("/customer")
	public String deleteAll() {
		
		grocery.deleteAll();
		return "all datas are deleted";
	}
	
	// add mapping for DELETE
	
	@DeleteMapping("/customer/{customerId}")
	public String deleteProduct(@PathVariable int customerId) {
		
		Customer tempCus = grocery.findById(customerId);
		
		
		if (tempCus == null) {
			throw new RuntimeException();
		}
		
		grocery.deleteById(customerId);
		
		return "ID "+customerId+" has been deleted Successfull";
	}
	
}
