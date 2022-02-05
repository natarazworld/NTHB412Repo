package com.nt.entity;

import lombok.Data;

@Data
public class CallerTune {
	private Integer tuneId;
	private String  tuneName;
	private  String movieName;
	private  Integer updationCount;  //for Versioning

}
