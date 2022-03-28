package com.nt.entity;

import lombok.Data;

@Data
public class Person {
	private Integer pid;
	private String pname;
	private  String company;
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", company=" + company + "]";
	}
	
	
}
