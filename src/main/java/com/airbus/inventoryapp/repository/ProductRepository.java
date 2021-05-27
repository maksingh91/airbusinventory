package com.airbus.inventoryapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.airbus.inventoryapp.entity.Products;

public interface ProductRepository extends CrudRepository<Products, Integer>{


	List<Products> findByProductCatagoryEquals(String category);

	
}
