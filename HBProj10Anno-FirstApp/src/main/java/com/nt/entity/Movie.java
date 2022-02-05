package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MOVIE_INFO")
@Data  //lombok api
@AllArgsConstructor
@DynamicInsert(value = true)
@Proxy(lazy = true)
public final class Movie {
	@Id //singular Id filed
	@Column(name="MID" )  //mapping with column
	private  Integer  mid;
	
	@Column(name="MNAME",length = 20)  //mapping with column
	private  String  mname;
	
	@Column(name="HERO",length=20)  //mapping with column
	private  String   hero;
	
	@Column(name="BUDGET")
	private Float budget;
	
	 public Movie() {
		 System.out.println("Movie:: 0-param constructor"+this.getClass());
	 }
	
}
