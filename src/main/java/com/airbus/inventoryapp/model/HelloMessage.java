/**
 * 
 */
package com.airbus.inventoryapp.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mahaveer
 *
 */

@Getter
@Setter
public class HelloMessage {

	private String name;

	  public HelloMessage() {
	  }

	  public HelloMessage(String name) {
	    this.name = name;
	  }
}
