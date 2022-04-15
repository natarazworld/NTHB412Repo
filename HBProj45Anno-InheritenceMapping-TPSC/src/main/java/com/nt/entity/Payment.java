package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ANNO_INH_PAYMENT_TPSC")
@Inheritance(strategy =InheritanceType.JOINED)  //TPSC
public abstract class Payment {
	@Id
	@GeneratedValue
	private Long txId;
	private  Double amount;
	private  LocalDateTime txDate;

}
