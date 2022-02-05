package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PrgmrProjId implements Serializable{
	@Column(name="PRGMRID")
	private Integer  prgmrId;
	@Column(name="PROJID")
	private  Integer projId;

}
