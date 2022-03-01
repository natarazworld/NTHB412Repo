package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="MOVIE_INFO")
@Data  //lombok api
@AllArgsConstructor
public class Movie {
	/*	@Id //singular Id filed
		@Column(name="MID" )  //mapping with column
		@GenericGenerator(name = "gen1",strategy = "increment")
		@GeneratedValue(generator ="gen1")*/
	
	/*	@Id //singular Id filed
		@GenericGenerator(name = "gen1",strategy = "identity")
		@GeneratedValue(generator ="gen1")*/
	
	/*	@Id
		@GenericGenerator(name="gen1",strategy = "sequence")
		@GeneratedValue(generator = "gen1")*/
	
	/*@Id
	@GenericGenerator(name="gen1",strategy = "sequence",
	                                     parameters = {@Parameter(name = "sequence_name", value = "HB_PRODID_SEQ1") }
	                                  )
	@GeneratedValue(generator = "gen1")*/
	
	/*	@Id
		@GenericGenerator(name="gen1",strategy = "sequence",
		                                     parameters = {@Parameter(name = "sequence_name", value = "NIT_PRODID_SEQ1"),
		                                    		                   @Parameter(name = "initial_value", value = "100"),
		                                    		                   @Parameter(name="increment_size",value="1")
		                                    		                 }
		                                  )
		@GeneratedValue(generator = "gen1")*/
	
	
	@Id
	@GenericGenerator(name="gen1",strategy = "seqhilo",
	                                     parameters = {@Parameter(name = "sequence_name", value = "NIT_PRODID_SEQ1"),
	                                                              @Parameter(name = "max_lo", value = "10")
	                                    		                 }
	                                  )
	@GeneratedValue(generator = "gen1")
	
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
