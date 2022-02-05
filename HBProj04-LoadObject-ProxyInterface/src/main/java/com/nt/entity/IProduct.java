package com.nt.entity;

import lombok.Data;

public interface IProduct {
	public Integer  getPid();
	public String  getPname();
	public  Float   getPrice();
	public Float getQty();
	public void  setPid(Integer pid);
	public void  setPname(String pname);
	public  void   setPrice(Float price);
	public void setQty(Float qty);


}
