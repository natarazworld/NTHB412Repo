package com.nt.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Data
@Entity
@Table(name="PRODUCT")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public  class Product {
	@GeneratedValue
	@Id
  private Integer pid;
   @Column(length = 20)
  private String pname;
  private  Float price;
  private  Float qty;
  
  public Product() {
	  System.out.println("Product:: 0-param constructor"+this.getClass());
  }
  
}
