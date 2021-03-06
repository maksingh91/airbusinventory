package com.airbus.inventoryapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mahaveer Singh Ratnoo
 *
 */

@Component
@Getter
@Setter
@ToString
public class ProductDTO {

	@PositiveOrZero
	private int productId;
	
	@NotBlank(message = "Product Name must not be blank")
	private String productName;
	
	@NotBlank(message = "Product Catagory must not be blank")
	private String productCatagory;
	
	@Size(min = 10, max = 500, message = "Product Description must be between 10 and 500 characters")
	private String productDescription;
	
	@PositiveOrZero(message = "Unit must be Positive or Zero")
	private int unit;
}
