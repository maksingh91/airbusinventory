/**
 * 
 */
package com.airbus.inventoryapp.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mahaveer
 *
 */

@Getter
@Setter
public class Greeting {

	private String content;

	  public Greeting() {
	  }

	  public Greeting(String content) {
	    this.content = content;
	  }
}
