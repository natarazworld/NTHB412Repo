package com.nt.entity;

import lombok.Data;

@Data
public class Employee extends Person {
	private  String desg;
	private Double salary;
	private  Integer deptno;
	@Override
	public String toString() {
		return "Employee [desg=" + desg + ", salary=" + salary + ", deptno=" + deptno + "]--;"+super.toString();
				
	}
	
	
	

}
