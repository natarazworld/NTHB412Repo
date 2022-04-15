package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Doctor {
	private  Integer docId;
	private  String docName;
	private  String hospital;
	private Set<Patient> patients;  //To  hold bunch of patients
	public Doctor() {
		System.out.println("Doctor:: 0-param constructor");
	}
	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", hospital=" + hospital + "]";
	}
	
	

}
