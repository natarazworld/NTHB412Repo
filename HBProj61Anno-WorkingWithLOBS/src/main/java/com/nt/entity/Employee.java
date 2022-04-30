//Employee.java
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="HB_ANNO_EMPLOYEE_LOBs")
public class Employee {
	@Id
	@GeneratedValue
	private  Integer empNo;
	@Column(length = 20)
	private  String empName;
	private  Float empSalary;
	@Lob
	private  byte[]  empPhoto;
	@Lob
	private  char[]  empResume;
	
	
	public Employee() {
	  System.out.println("Employee:: 0-param constructor");
	}
	

}//class
