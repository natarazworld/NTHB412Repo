package com.nt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrgmrProjId implements Serializable{
	private Integer  prgmrId;
	private  Integer projId;

}
