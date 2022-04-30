//Student.java (parent class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="HB_ANNO_STUDENT")
public class Student implements Serializable {
	@Id
	@GeneratedValue
	private  Integer sno;
	@Column(length = 20)
	private String sname;
	@Column(length = 20)
	private  String sadd;
	@OneToOne(targetEntity = LibraryMembership.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "lid",referencedColumnName = "sno")
	private LibraryMembership  libraryDetails;
	
	public Student() {
		System.out.println("Student:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + "]";
	}
	

}
