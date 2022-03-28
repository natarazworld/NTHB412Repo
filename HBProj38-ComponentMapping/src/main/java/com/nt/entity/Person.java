package com.nt.entity;

import java.io.Serializable;

import lombok.Data;


@Data
public class Person  implements Serializable {
	private Integer pid;
	private String pname;
	private  String paddrs;
	private JobDetails details;

}
