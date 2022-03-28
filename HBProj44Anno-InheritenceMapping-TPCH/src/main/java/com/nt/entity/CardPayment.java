package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("card")
public class CardPayment extends Payment {
	private  Long cardNo;
	@Column(length = 15)
	private   String cardType;
	@Column(length = 15)
	private  String gateway;
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", gateway=" + gateway +super.toString()+ "]";
	}
	
}
