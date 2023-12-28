package com.springboot.POC.GroceryManagemnet.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
	
	 @Column(name = "Name")
	private String name;
	
	 @Column(name = "Email_ID")
	private String email;

	@OneToMany(targetEntity= Product.class, cascade= CascadeType.ALL)
	@JoinColumn(name="forign_key_id" , referencedColumnName="id")
	private List<Product> products;
	


	public Customer() {

	}

	public Customer(String name, String email, List<Product> products) {
		this.name = name;
		this.email = email;
		this.products = products;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", products=" + products + "]";
	}

	
	
	
	
	
}
