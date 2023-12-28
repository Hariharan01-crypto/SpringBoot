package com.springboot.POC.GroceryManagemnet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.POC.GroceryManagemnet.pojo.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {

	
}
