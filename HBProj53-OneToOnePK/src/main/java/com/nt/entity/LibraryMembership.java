package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LibraryMembership  implements Serializable {
	private Integer lid;
	private String type;
	private  LocalDate  doj;
	private  Student  studentDetails;
	
	public LibraryMembership() {
		System.out.println("LibraryMembership:: 0-param constructor");
	}

	
	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", type=" + type + ", doj=" + doj + "]";
	}
	
	

}
