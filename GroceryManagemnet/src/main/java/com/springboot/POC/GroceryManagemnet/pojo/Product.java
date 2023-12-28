package com.springboot.POC.GroceryManagemnet.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	
	private String productName;
	
    private String productQuantity;
	
    private int price;
	
    @ManyToOne
    @JoinColumn(name="forign_key_id")
	private Customer customer;

    
    public Product() {
    	
    }
	
	public Product(String productName, String productQuantity, int price) {
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productName=" + productName + ", productQuantity=" + productQuantity
				+ ", price=" + price + "]";
	}
	
	
	
	
}