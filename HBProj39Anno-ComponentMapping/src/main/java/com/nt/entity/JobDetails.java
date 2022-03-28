package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class JobDetails {
	@Column(length = 20)
	private String  desg;
	@Column(length = 10)
	private  String company;
	private Double salary;

}
