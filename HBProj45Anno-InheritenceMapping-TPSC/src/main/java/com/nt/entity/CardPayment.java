package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ANNO_INH_CARD_PAYMENT_TPSC")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID",referencedColumnName = "TXID")
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
