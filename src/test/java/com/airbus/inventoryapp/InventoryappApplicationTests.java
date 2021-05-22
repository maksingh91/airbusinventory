package com.airbus.inventoryapp;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.airbus.inventoryapp.model.ProductDTO;
import com.airbus.inventoryapp.repository.ProductRepository;
import com.airbus.inventoryapp.service.ProductsService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class InventoryappApplicationTests {

	@Mock
    private ProductRepository productRepository;

    @InjectMocks // auto inject productRepository
    private ProductsService productService = new ProductsService();

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @BeforeEach
    void setMockOutput() {
        when(productService.showProduct(3)).thenReturn(new ProductDTO());
    }

	
	@Test
	@DisplayName("Test DTO Validations with Valid Values")
	public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
		  /*ResponseEntity<String> response = restTemplate.getForEntity(
		            new URL("http://localhost:" + port + "/").toString(), String.class);
		        assertEquals("Hello Controller", response.getBody());*/
	}

	
	@Test
	@DisplayName("Test DTO Validations with InValid Values")
	public void whenPostRequestToUsersAndInValidUser_thenCorrectResponse() throws Exception {
	    /*String user = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/users")
	      .content(user)
	      .contentType(MediaType.APPLICATION_JSON_UTF8))
	      .andExpect(MockMvcResultMatchers.status().isBadRequest())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory")))
	      .andExpect(MockMvcResultMatchers.content()
	        .contentType(MediaType.APPLICATION_JSON_UTF8));
	    }*/
	}
}
