//Product.java (Entity class) 
package com.nt.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PRODUCT")
@NamedNativeQuery(name ="GET_PRODS_BY_PRICE_RANGE",
                                       query = "SELECT * FROM PRODUCT WHERE PRICE>=? AND PRICE<=?",
                                       resultClass =Product.class)
@NamedNativeQuery(name ="HIKE_PRICE_BY_PROD_NAME",
                                        query = "UPDATE PRODUCT SET PRICE=PRICE+? WHERE PNAME=?")


public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int pid;
	private String pname;
	private Float price;
	private  Float qty;
	
	public Product() {
		System.out.println("Product:: 0-param constructor"+this.hashCode());
	}
	
}
