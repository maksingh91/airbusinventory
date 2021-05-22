package com.airbus.inventoryapp.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Mahaveer Singh Ratnoo
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.airbus.inventoryapp.contorller"))
	                .paths(PathSelectors.ant("/inventory/*"))
	                .build()
	                .apiInfo(apiInfo());
	    }
	 

	 private ApiInfo apiInfo() {
		    return new ApiInfo(
		      "Airbus Inventory REST API", 
		      "Welcom to Airbus Inventory Rest API Platform", 
		      "V1.0", 
		      "Terms of service", 
		      new Contact("AirbusPoc", "https://airbuspoc.com", "myeaddress@airbuspoc.com"), 
		      "License of API", "https://airbuspoc.com", Collections.emptyList());
		}
}
