package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="HB_ANNO_PASSPORT")
public class Passport implements Serializable {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "PSPT_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer  passportNo;
	@Column(length = 20)
	private  String   country;
	private  LocalDate expiryDate;
	@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private   Person personDetails;  //for OneToOne Association
	public Passport() {
		System.out.println("Passport:: 0-param constructor::"+this.getClass());
	}
	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", country=" + country + ", exipiryDate=" + expiryDate + "]";
	}
	
	

}
