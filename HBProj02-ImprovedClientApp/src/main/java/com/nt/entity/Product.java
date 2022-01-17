//Entity calss or BO class or Model class or Persistence class 
package com.nt.entity;

import lombok.Data;


@Data
public class Product {
	private  Integer pid;
	private String pname;
	private float price;
	private  float qty;
	
}
