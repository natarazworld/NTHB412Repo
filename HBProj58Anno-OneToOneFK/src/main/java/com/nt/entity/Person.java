package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="HB_ANNO_PERSON")
public class Person implements Serializable{
	@GeneratedValue
	@Id
	private Integer pid;
	@Column(length = 20)
	private  String pname;
	@Column(length = 20)
	private  String paddrs;
	
	public Person() {
		System.out.println("Person:: 0-param constructor::"+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
}
