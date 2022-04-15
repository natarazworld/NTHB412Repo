package com.nt.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person implements Serializable{
	private Integer pid;
	private  String pname;
	private  String paddrs;
	
	public Person() {
		System.out.println("Person:: 0-param constructor::"+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
}
