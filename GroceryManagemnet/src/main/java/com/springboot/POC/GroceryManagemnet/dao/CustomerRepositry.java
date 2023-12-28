package com.springboot.POC.GroceryManagemnet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.POC.GroceryManagemnet.pojo.Customer;

@Repository
public interface CustomerRepositry extends JpaRepository<Customer, Integer> {

}
