package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PROGRAMMERPROJECTINFO")
public class ProgrammerProjectInfo {
	//HAS -A  property of Id class
	@EmbeddedId
	private PrgmrProjId id;
	@Column(length = 20,name = "PRGMRNAME")
	private  String prgmrName;
	@Column(length = 20,name="PROJNAME")
	private  String projName;
	@Column(name="SALARY")
	private  double salary;
	@Column(name="BUDGET")
	private double  budget;
	
	

}
