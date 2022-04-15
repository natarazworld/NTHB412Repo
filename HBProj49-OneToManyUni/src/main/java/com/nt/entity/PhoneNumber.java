//PhoneNumber.java (child class)
package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class PhoneNumber implements Serializable{
	private Integer regNo;
	private  Long  mobileNo;
	private  String numberType;
	private  String  provider;
	
	 //taking  property for FK column is pure optional
	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", mobileNo=" + mobileNo + ", numberType=" + numberType + ", provider="
				+ provider + "]";
	}

	
}
