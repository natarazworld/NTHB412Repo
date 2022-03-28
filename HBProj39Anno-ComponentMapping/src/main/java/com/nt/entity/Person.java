package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Table(name=" HB_COMP_PERSON")
@Entity
public class Person  implements Serializable {
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length = 20)
	private String pname;
	@Column(length = 20)
	private  String paddrs;
	@Embedded   //for component property
	private JobDetails details;

}
