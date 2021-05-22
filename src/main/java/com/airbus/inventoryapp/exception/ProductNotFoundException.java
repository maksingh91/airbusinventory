/**
 * 
 */
package com.airbus.inventoryapp.exception;

/**
 * @author Mahaveer Singh Ratnoo
 *
 */
public class ProductNotFoundException extends RuntimeException{
	 public ProductNotFoundException(int id) {

	        super(String.format("Product with Id %d not found", id));
	    }
}
