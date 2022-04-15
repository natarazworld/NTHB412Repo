package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Passport implements Serializable {
	private  Integer  passportNo;
	private  String   country;
	private  LocalDate expiryDate;
	private   Person personDetails;  //for OneToOne Association
	public Passport() {
		System.out.println("Passport:: 0-param constructor::"+this.getClass());
	}
	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", country=" + country + ", exipiryDate=" + expiryDate + "]";
	}
	
	

}
