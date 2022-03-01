package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="MOVIE_INFO")
@Data  //lombok api
@AllArgsConstructor
public class Movie {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)*/
	
	/*@Id
	@SequenceGenerator(name = "gen1",sequenceName = "JPA_MID_SEQ", initialValue = 700 ,allocationSize =5)
	@GeneratedValue(generator = "gen1", strategy= GenerationType.SEQUENCE)*/
	
	/*	@Id
		@SequenceGenerator(name = "gen1",sequenceName = "JPA_MID_SEQ1")
		@GeneratedValue(generator = "gen1", strategy= GenerationType.SEQUENCE)*/
	
	/*	@Id
		@TableGenerator(name="gen1",table = "ID_TAB",pkColumnName = "PK_COL",pkColumnValue = "MID",
		                                   valueColumnName = "VAL_COL",initialValue = 400, allocationSize = 2)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)	*/
	
	/*@Id
	 @GeneratedValue(strategy = GenerationType.TABLE)	*/
	
	/*@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)*/
	
	/*@Id
	@SequenceGenerator(name = "gen1",sequenceName = "JPA_MID_SEQ", initialValue = 700 ,allocationSize =5)
	 @GeneratedValue(generator = "gen1",strategy= GenerationType.AUTO)*/
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
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
