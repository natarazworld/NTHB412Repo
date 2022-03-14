//Entity calss or BO class or Model class or Persistence class 
package com.nt.entity;

import lombok.Data;

@Data
public class SpecialProduct {
	private  int pid;
	private String pname;
	private Float price;
	private  Float qty;
	
	public SpecialProduct() {
		System.out.println("Product:: 0-param constructor"+this.hashCode());
	}
	
}
