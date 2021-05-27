package com.airbus.inventoryapp.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.inventoryapp.entity.Products;
import com.airbus.inventoryapp.exception.NoDataFoundException;
import com.airbus.inventoryapp.exception.ProductNotFoundException;
import com.airbus.inventoryapp.model.ProductDTO;
import com.airbus.inventoryapp.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Mahaveer Singh Ratnoo
 *
 */

@Service
@Slf4j
public class ProductsService {

	@Autowired
	ProductRepository productRepository;

	ModelMapper modelMapper;
	
	{
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
	}
	

	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param
	 * @return List<ProductDTO>
	 * @exception
	 */
	public List<ProductDTO> getAllProducts() {
		
		Type listType = new TypeToken<List<ProductDTO>>() {}.getType();
		List<Products> productLst = (List<Products>) productRepository.findAll();
		if (productLst.isEmpty()) 
		{
			log.error("ProductsService: getAllProducts(): No products found");
			throw new NoDataFoundException("No data found");
	    }

		List<ProductDTO> productDtoLst = modelMapper.map(productLst, listType);
		return productDtoLst;
	}

	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param id
	 * @return ProductDTO
	 * @exception
	 */
	public ProductDTO showProduct(int id) {
		Products product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
		return modelMapper.map(product, ProductDTO.class);
	}

	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param ProductDTO
	 * @return void
	 * @exception
	 */
	public void saveProduct(ProductDTO product) {
		productRepository.save(modelMapper.map(product, Products.class));

	}

	/**
	 * @author Mahaveer Singh Ratnoo
	 * @param category
	 * @return List<ProductDTO>
	 * @exception
	 */
	public List<ProductDTO> searchProduct(String category) {
		Type listType = new TypeToken<List<ProductDTO>>() {}.getType();
		List<Products> productLst = (List<Products>) productRepository.findByProductCatagoryEquals(category);
		if (productLst.isEmpty()) 
		{
			log.error("ProductsService: getAllProducts(): No products found unnder this Category");
			throw new NoDataFoundException("No data found Under this Category");
	    }

		List<ProductDTO> productDtoLst = modelMapper.map(productLst, listType);
		return productDtoLst;
	}

}
