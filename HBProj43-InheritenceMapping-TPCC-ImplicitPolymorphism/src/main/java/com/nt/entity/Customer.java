package com.nt.entity;

import lombok.Data;

@Data
public class Customer extends Person {
	private  Double billAmt;
	private Integer billNo;
	
	@Override
	public String toString() {
		return "Customer [billAmt=" + billAmt + ", billNo=" + billNo + "]"+super.toString();
	}
	
	
	

}
