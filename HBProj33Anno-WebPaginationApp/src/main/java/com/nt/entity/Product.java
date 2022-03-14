//Entity calss or BO class or Model class or Persistence class 
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PRODUCT")
@NamedQuery(name = "HQL_GET_PRODUCTS_BY_PRICE_RANGE",
                             query="from Product where price>=:min and price<=:max")
@NamedQuery(name = "INCREASE_PRODUCT_PRICE_BY_PRICE_RANGE",
                             query="update Product set price=price+:newValue where price>=:range")

public class Product {
	@Id
	@GeneratedValue
	private  int pid;
	@Column(length=20)
	private String pname;
	private Float price;
	private  Float qty;
	
	public Product() {
		System.out.println("Product:: 0-param constructor"+this.hashCode());
	}
	
}
