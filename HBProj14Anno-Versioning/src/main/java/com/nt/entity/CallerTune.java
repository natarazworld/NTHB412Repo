package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="CALLERTUNE_ANNO")
public class CallerTune {
	@Id
	@GeneratedValue
	private Integer tuneId;
	@Column(length = 20)
	private String  tuneName;
	@Column(length = 20)
	private  String movieName;
	@Version
	private  Integer updationCount;  //for Versioning

}
