package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ANNO_INH_CHEQUE_PAYMENT_TPSC")
@PrimaryKeyJoinColumn(name="PAYMENT_ID",referencedColumnName = "TXID")
public class ChequePayment extends Payment {
	private  Long chequeNo;
	@Column(length = 15)
	private   String chequeType;
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + super.toString()+ "]";
	}
}
