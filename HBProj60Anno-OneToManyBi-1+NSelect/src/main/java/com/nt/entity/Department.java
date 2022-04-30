//Department.java
package com.nt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="ANNO_HB_DEPARTMENT")
public class Department {
	@Id
	@GeneratedValue
	private Integer deptNo;
	@Column(length = 20)
	private String deptName;
	@Column(length = 20)
	private  String  deptHead;
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,
			                mappedBy = "dept",orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	//@JoinColumn(name="DEPARTMENT_NO",referencedColumnName ="DEPTNO")
	private  Set<Employee>  employees;  //for one to many association
	
	public Department() {
		System.out.println("Department:: 0-param constructor"+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}
	
	

}
