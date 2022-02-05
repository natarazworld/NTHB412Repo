package com.nt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="CALLERTUNE_ANNO_VER_TS")
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
	@CreationTimestamp
	private  Timestamp  launchTime;  // holds record insertion time
	@UpdateTimestamp
	private   Timestamp  lastUpdationTime;  //holds record lastupdation time

}
