package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Patient {
	private Integer patId;
	private  String patName;
	private  String problem;
	private  Set<Doctor> doctors;  //To hold bunch of  doctors
	
	public Patient() {
		System.out.println("Patient:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", patName=" + patName + ", problem=" + problem + "]";
	}
	
}//class
