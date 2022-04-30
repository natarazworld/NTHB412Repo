package com.nt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="ANNO_HB_PATIENT")
public class Patient {
	@SequenceGenerator(name="gen1",sequenceName = "PAT_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy =GenerationType.SEQUENCE )
	@Id
	private Integer patId;
	@Column(length = 20)
	private  String patName;
	@Column(length = 20)
	private  String problem;
	@ManyToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "patients")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private  Set<Doctor> doctors;  //To hold bunch of  doctors
	
	public Patient() {
		System.out.println("Patient:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", patName=" + patName + ", problem=" + problem + "]";
	}
	
}//class
