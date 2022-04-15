package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department implements IDepartment {
	private Integer deptNo;
	private String deptName;
	private  String  deptHead;
	private  Set<Employee>  employees;  //for one to many association
	
	public Department() {
		System.out.println("Department:: 0-param constructor"+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}
	
	

}
