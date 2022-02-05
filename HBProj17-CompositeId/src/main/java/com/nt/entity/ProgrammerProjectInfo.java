package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammerProjectInfo {
	//HAS -A  property of Id class
	private PrgmrProjId id;
	private  String prgmrName;
	private  String projName;
	private  double salary;
	private double  budget;
	
	

}
