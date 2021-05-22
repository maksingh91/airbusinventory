package com.airbus.inventoryapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "productid")
	private int productId;
	
	@Column(name = "productname")
	private String productName;
	
	@Column(name = "productcatagory")
	private String productCatagory;
	
	@Column(name = "productdescription")
	private String productDescription;
	
	@Column(name = "units")
	private int unit;
}
