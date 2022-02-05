//Entity calss or BO class or Model class or Persistence class 
package com.nt.entity;

import javax.persistence.Column;

public class Product {
	private  int pid;
	private String pname;
	private Float price;
	private  Float qty;
	
	
	//setters & getters  (Alt+shift+S ,R )
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getQty() {
		return qty;
	}
	public void setQty(Float qty) {
		this.qty = qty;
	}
	
	
   //toString()  (Alt+shift+S, S)
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
	}
	
	
	

}
