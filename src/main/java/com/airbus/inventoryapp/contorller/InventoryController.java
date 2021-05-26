package com.airbus.inventoryapp.contorller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.airbus.inventoryapp.model.ProductDTO;
import com.airbus.inventoryapp.service.ProductsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Mahaveer Singh Ratnoo
 * 
 */

@Slf4j
@RestController
@RequestMapping(value = "/inventory")
@CrossOrigin
@Api(value = "Inventory", description = "Operations pertaining to products available in Inventory")
public class InventoryController {

	@Autowired
	ProductsService productService;
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

	//Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param
	 * @return ResponseEntity<List<ProductDTO>>
	 * @exception
	 */
	@ApiOperation(value = "View a table of available products", response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/getallproducts")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		log.info("inside InventoryController getAllProducts()");
		return new ResponseEntity<List<ProductDTO>>(productService.getAllProducts(), HttpStatus.OK);
	}

	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param id
	 * @return ResponseEntity<ProductDTO>
	 * @exception
	 */
	@ApiOperation(value = "Fetch a product with product ID", response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/getproduct")
	public ResponseEntity<ProductDTO> showProduct(@RequestParam Integer id) {
		log.info("inside InventoryController showProduct() Product ID : "+ id);
		return new ResponseEntity<ProductDTO>(productService.showProduct(id), HttpStatus.OK); 
	}

	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param ProductDTO
	 * @return ResponseEntity<String>
	 * @exception
	 */
	@ApiOperation(value = "Add a product", response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping(value = "/addproduct")
	public ResponseEntity<String> saveProduct(@Valid @RequestBody ProductDTO product) {
		log.info("inside InventoryController saveProduct() Product is :"+ product.toString());
		productService.saveProduct(product);
		return new ResponseEntity<String>("Product saved successfully", HttpStatus.OK);
	}

	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param ProductDTO
	 * @return ResponseEntity<String>
	 * @exception
	 */
	@ApiOperation(value = "Update a product", response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping(value = "/updateproduct")
	public ResponseEntity<String> updateProduct(@Valid @RequestBody ProductDTO product) {
		log.info("inside InventoryController updateProduct() Product is :"+ product.toString());
		productService.saveProduct(product);
		return new ResponseEntity<String>("Product updated successfully", HttpStatus.OK);
	}
}
