package com.airbus.inventoryapp.contorller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
@CrossOrigin
@RequestMapping(value = "/inventory")
@Api(value = "Inventory", description = "Operations pertaining to products available in Inventory")
public class InventoryController {

	@Autowired
	ProductsService productService;

	//Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param
	 * @return ResponseEntity<List<ProductDTO>>
	 * @exception
	 */
	@ApiOperation(value = "View a list of available products", response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/getallproducts")
	public ResponseEntity<List<ProductDTO>> getAllProducts(/* @AuthenticationPrincipal Principal userInfo */) {
		log.info("inside InventoryController getAllProducts()");
		//log.info("UserInfo"+userInfo);
		return new ResponseEntity<List<ProductDTO>>(productService.getAllProducts(), HttpStatus.OK);
	}

	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param id
	 * @return ResponseEntity<ProductDTO>
	 * @throws Exception 
	 * @exception
	 */
	/*@ApiOperation(value = "Fetch a product with product ID", response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/getproduct")
	public ResponseEntity<ProductDTO> showProduct(@RequestParam Integer id) {
		log.info("inside InventoryController showProduct() Product ID : "+ id);
		return new ResponseEntity<ProductDTO>(productService.showProduct(id), HttpStatus.OK); 
	}*/
	
	
	/*
	 * @GetMapping(value = "/getfluxproduct") private Flux<ProductDTO>
	 * getAllEmployees() { return
	 * Flux.fromIterable(productService.getAllProducts()); }
	 */
	
	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param id
	 * @return ResponseEntity<List<ProductDTO>>
	 * @exception
	 */
	@ApiOperation(value = "Fetch all products with Category", response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/searchproductsbycategory")
	public ResponseEntity<List<ProductDTO>> searchProductByCategory(@RequestParam String category/*, @AuthenticationPrincipal Principal userInfo*/) {
		log.info("inside InventoryController searchProductByCategory() Category : "+ category);
		return new ResponseEntity<List<ProductDTO>>(productService.searchProduct(category), HttpStatus.OK); 
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
	public ResponseEntity<List<String>> saveProduct(
			@Valid @RequestBody ProductDTO product/* , @AuthenticationPrincipal Principal userInfo */) {
		log.info("inside InventoryController saveProduct() Product is :"+ product.toString());
		productService.saveProduct(product);
		List<String> msg = new ArrayList<String>();
		msg.add("Product saved successfully");
		return new ResponseEntity<List<String>>(msg, HttpStatus.OK);
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
	public ResponseEntity<List<String>> updateProduct(
			@Valid @RequestBody ProductDTO product/* , @AuthenticationPrincipal Principal userInfo */) {
		log.info("inside InventoryController updateProduct() Product is :"+ product.toString());
		productService.saveProduct(product);
		List<String> msg = new ArrayList<String>();
		msg.add("Product updated successfully");
		return new ResponseEntity<List<String>>(msg, HttpStatus.OK);
	}
}
